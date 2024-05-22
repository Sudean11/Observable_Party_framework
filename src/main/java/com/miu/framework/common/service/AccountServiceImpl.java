package com.miu.framework.common.service;
import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.bank.observer.Observable;
import com.miu.framework.bank.observer.Observer;
import com.miu.framework.common.Factory.DAOFactoryImpl;
import com.miu.framework.common.Repositories.PartyDAO;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.Repositories.AccountDAO;
import com.miu.framework.common.Factory.DAOFactory;
import com.miu.framework.common.entity.Party;

import java.util.*;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService, Observable {

	List<Observer> observerList = new ArrayList<>();
	private  AccountDAO accountDAO;
	private  PartyDAO partyDAO;

	public AccountServiceImpl(AccountDAO accountDAO, PartyDAO partyDAO){
		this.accountDAO = accountDAO;
		this.partyDAO = partyDAO;
	}

	public void deposit(String accountNumber, double amount) {
		System.out.println("Amount :: "+amount);
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		notifyObservers(account, amount);
	}

	@Override
	public Account createAccount(Party party, StrategyAccountType accountTypeStrategy, String accountNumber) {
		Account account =  new Account(accountNumber, party, accountTypeStrategy);
		Party partyExists = partyDAO.loadParty(party.getEmail());
		if(partyExists != null){
			party = partyDAO.loadParty(party.getEmail());
		}else{
			partyDAO.saveParty(party);
		}
		accountDAO.save(account);
		party.addAccount(account);
		partyDAO.updateParty(party);
		return account;
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
		DAOFactory accountDao = new DAOFactoryImpl();
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
	public String getTransaction(String accountNumber) {
		return accountDAO.loadAccount(accountNumber).getTransactionHistory().stream().map(Transaction::toString).collect(Collectors.toList()).toString();
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
