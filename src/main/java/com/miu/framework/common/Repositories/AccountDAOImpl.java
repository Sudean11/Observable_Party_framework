package com.miu.framework.common.Repositories;

import com.miu.framework.bank.observer.EmailObserver;
import com.miu.framework.common.Repositories.storage.DataAccessFacade;
import com.miu.framework.common.Repositories.storage.StorageType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountDAOImpl implements AccountDAO {
	private static volatile AccountDAOImpl instance;
	private final DataAccessFacade dataAccess;

	private AccountDAOImpl() {
		dataAccess = new DataAccessFacade();
	}

	public static AccountDAO getAccountDAO() {
		if (instance == null) {
			synchronized (AccountDAOImpl.class) {
				if (instance == null) {
					instance = new AccountDAOImpl();
				}
			}
		}
		return instance;
	}

	@Override
	public void save(Account account) {
		dataAccess.save(account, account.getAccountNumber(), StorageType.ACCOUNTS);
	}

	@Override
	public void removeAccount(Account account) {
		dataAccess.remove(account.getAccountNumber(), StorageType.ACCOUNTS);
	}

	@Override
	public Account loadAccount(String accountNumber) {
		return dataAccess.load(accountNumber, StorageType.ACCOUNTS);
	}

	@Override
	public List<Account> getAccounts() {
		return dataAccess.getAll(StorageType.ACCOUNTS);
	}

	@Override
	public void update(Account account) {
		dataAccess.update(account, account.getAccountNumber(), StorageType.ACCOUNTS);
	}
}
