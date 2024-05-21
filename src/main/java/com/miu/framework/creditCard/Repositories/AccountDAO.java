package com.miu.framework.creditCard.Repositories;

import com.miu.framework.common.entity.Account;


import java.util.ArrayList;
import java.util.Collection;

public  abstract  class AccountDAO {
	ArrayList<Account> accounts;
	public void  save(Account account){
		saveAccount(account);
	};
	public void updateAccount(Account account){
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accounts.remove(accountexist); // remove the old
			accounts.add(account); // add the new
		}
	};
	public Account loadAccount(String accountnumber){
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountnumber) {
				return account;
			}
		}
		return null;
	};
	public Collection<Account> getAccounts(){
      return accounts;
	};
	abstract void saveAccount(Account account);
	public void removeAccount(Account account){
		accounts.remove(account);
	}
}
