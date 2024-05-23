package com.miu.observable_party_account.framework.service;
import com.miu.framework.Rule.MinimumBalanceRule;
import com.miu.framework.common.Rule.RuleEngine;
import com.miu.observable_party_account.bank.entities.Transaction;
import com.miu.observable_party_account.framework.strategy.StrategyAccountType;
import com.miu.observable_party_account.bank.observer.Observable;
import com.miu.observable_party_account.bank.observer.Observer;
import com.miu.observable_party_account.framework.repositories.PartyDAO;
import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.repositories.AccountDAO;
import com.miu.observable_party_account.framework.entity.Party;
import com.miu.observable_party_account.framework.utils.enums.TransactionType;

import java.util.*;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService, Observable {

	private volatile static AccountServiceImpl instance;

	RuleEngine ruleEngine = new RuleEngine();

	public static AccountServiceImpl getAccountServiceForBankImpl(){
		if(Objects.isNull(instance)){
			synchronized (AccountServiceImpl.class){
				if(Objects.isNull(instance)){
					instance = new AccountServiceImpl(null, null);
				}
			}
		}
		return instance;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setPartyDAO(PartyDAO partyDAO) {
		this.partyDAO = partyDAO;
	}

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
		notifyObservers(account, amount, TransactionType.DEPOSIT);
	}

	@Override
	public Account createAccount(Party party, StrategyAccountType accountTypeStrategy, String accountNumber) {
		Account account =  new Account(accountNumber, party, accountTypeStrategy);
		Party partyExists = partyDAO.loadParty(party.getEmail());

		//Check if party already exists
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

		ruleEngine.addRule(new MinimumBalanceRule(100.00));
		Account account = accountDAO.loadAccount(accountNumber);
		double balance = account.getBalance();
		if(validateMininmumBalance(amount, account, balance)){
			account.withdraw(amount);
		}
		accountDAO.updateAccount(account);
		notifyObservers(account, amount, TransactionType.WITHDRAWAL);
	}

	private  boolean validateMininmumBalance(double amount,Account account, double balance) {
		if (ruleEngine.validate(account, amount)) {
			balance += amount;
			System.out.println("Charged " + amount + ". New balance is " + balance);
			return true;
		} else {
			System.out.println("Charge denied due to rule violation.");
		}
		return false;
	}

	@Override
	public void addInterest() {
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
				report.append(f.generateReport()+"\n");
			});
		});
		System.out.println(report.toString());
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
	public void notifyObservers(Account account, double amount, TransactionType transactionType) {
		for(Observer observer: observerList){
			observer.update(account, amount, TransactionType.WITHDRAWAL);
		}
	}
}
