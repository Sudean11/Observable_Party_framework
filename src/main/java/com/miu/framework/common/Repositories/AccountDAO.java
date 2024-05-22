package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Account;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public  interface  AccountDAO {

	public void  save(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(String accountnumber);
	public List<Account> getAccounts();
	abstract void saveAccount(Account account);
	public void removeAccount(Account account);
}
