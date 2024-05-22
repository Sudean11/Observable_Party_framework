package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountDAOImpl implements AccountDAO {
	List<Account> accounts;

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
