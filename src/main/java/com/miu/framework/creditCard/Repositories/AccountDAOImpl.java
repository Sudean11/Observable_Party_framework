package com.miu.framework.creditCard.Repositories;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;

public class AccountDAOImpl extends AccountDAO {
	public AccountDAOImpl(){
		this.accounts=new ArrayList<>();
	}
	public void saveAccount(Account account) {
		this.accounts.add(account); // add the new
	}

}
