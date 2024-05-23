package com.miu.observable_party_account.framework.repositories;

import com.miu.observable_party_account.framework.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountDAOImpl implements AccountDAO {
	List<Account> accounts;

	private volatile static AccountDAO instance;

	public static AccountDAO getAccountDAO(){
		if(Objects.isNull(instance)){
			synchronized (AccountDAO.class){
				if(Objects.isNull(instance)){
					instance = new AccountDAOImpl();
				}
			}
		}
		return instance;
	}

	public AccountDAOImpl(){
		this.accounts=new ArrayList<>();
	}
	public void saveAccount(Account account) {
		this.accounts.add(account); // add the new
	}

	@Override
	public void removeAccount(Account account) {
		accounts.remove(account);
	}

	public void  save(Account account){
		accounts.add(account);
	};
	public void updateAccount(Account account){
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accounts.remove(accountexist);
			accounts.add(account);
		}
	};
	public Account loadAccount(String accountnumber){
		for (Account account : accounts) {
			if (Objects.equals(account.getAccountNumber(), accountnumber)) {
				return account;
			}
		}
		return null;
	};
	public List<Account> getAccounts(){
		return accounts;
	};
}
