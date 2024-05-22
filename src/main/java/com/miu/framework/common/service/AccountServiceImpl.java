package com.miu.framework.common.service;
import com.miu.framework.bank.entities.StrategyAccountType;
import com.miu.framework.bank.observer.Observable;
import com.miu.framework.bank.observer.Observer;
import com.miu.framework.common.Factory.DAOAndServiceImpl;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.Repositories.AccountDAO;
import com.miu.framework.common.Factory.DAOAndServiceFactory;
import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService, Observable {

	List<Observer> observerList = new ArrayList<>();
	private final AccountDAO accountDAO;

	public AccountServiceImpl(DAOAndServiceFactory factory){
		accountDAO = factory.createAccountDAO();
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		notifyObservers(account,  amount);
	}

	@Override
	public Account createAccount(Party party, StrategyAccountType accountTypeStrategy, String accountNumber) {
		System.out.println("Called");
		return new Account(accountNumber, party, accountTypeStrategy);
	}

	public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		if(account.getBalance() < 0){
			notifyObservers(account, amount);
			return;
		}
		accountDAO.updateAccount(account);
		notifyObservers(account, amount);
	}

	@Override
	public void addInterest() {
		DAOAndServiceFactory accountDao = new DAOAndServiceImpl();
		AccountDAO accountDAO = accountDao.createAccountDAO();
		List<Account> accounts = accountDAO.getAccounts();
		for(Account account: accounts){
			account.deposit(account.calculateInterest(account.getBalance()));
		}
	}

	@Override
	public String generateReport() {
		StringBuilder report = new StringBuilder();
		Map<Party,List<Account>> accounts = accountDAO.getAccounts().stream()
				.collect(Collectors.groupingBy(Account::getOwner));
		accounts.forEach((k,v)->{
			report.append("Owner : "+k.getEmail()+"\n");
			v.forEach(f->{
				report.append("\t\t"+f.generateReport()+"\n");
			});
		});
		return report.toString();
	}

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers(Account account, double amount) {
		for(Observer observer: observerList){
			observer.update(account, amount);
		}
	}
}
