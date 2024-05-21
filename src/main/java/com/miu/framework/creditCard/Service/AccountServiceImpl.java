package com.miu.framework.creditCard.Service;


import com.miu.framework.common.entity.Account;
import com.miu.framework.creditCard.Repositories.AccountDAO;
import com.miu.framework.creditCard.Factory.AccountDAOAndServiceFactory;
import com.miu.framework.creditCard.entities.CreditAccount;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private AccountDAOAndServiceFactory factory;
	public AccountServiceImpl(AccountDAOAndServiceFactory factory){
		this.factory=factory;
		accountDAO = factory.createAccountDAO();
	}


	public Account createAccount(String accountNumber, String name,double amount) {
		Account account = new CreditAccount(accountNumber,name,amount);
		accountDAO.save(account);
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	@Override
	public void addInterest(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.addInterest();
		accountDAO.updateAccount(account);
	}
}
