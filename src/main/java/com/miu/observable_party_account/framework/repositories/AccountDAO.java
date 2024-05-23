package com.miu.observable_party_account.framework.repositories;

import com.miu.observable_party_account.framework.entity.Account;


import java.util.List;

public  interface  AccountDAO {

	public void  save(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(String accountnumber);
	public List<Account> getAccounts();
	abstract void saveAccount(Account account);
	public void removeAccount(Account account);
}
