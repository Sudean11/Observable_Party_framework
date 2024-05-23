package com.miu.framework.common.Repositories;

import com.miu.framework.common.Repositories.storage.DataAccessFacade;
import com.miu.framework.common.Repositories.storage.StorageType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class CreditCardDAOImpl implements AccountDAO {
    private static volatile CreditCardDAOImpl instance;
    private final DataAccessFacade dataAccess;

    private CreditCardDAOImpl() {
        dataAccess = new DataAccessFacade();
    }

    public static CreditCardDAOImpl getPartyDAO() {
        if (instance == null) {
            synchronized (CreditCardDAOImpl.class) {
                if (instance == null) {
                    instance = new CreditCardDAOImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void save(Account account) {
        dataAccess.save(account, account.getAccountNumber(), StorageType.CREDIT_CARDS);
    }

    @Override
    public void removeAccount(Account account) {
        dataAccess.remove(account.getAccountNumber(), StorageType.CREDIT_CARDS);
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return dataAccess.load(accountNumber, StorageType.CREDIT_CARDS);
    }

    @Override
    public List<Account> getAccounts() {
        return dataAccess.getAll(StorageType.CREDIT_CARDS);
    }

    @Override
    public void update(Account account) {
        dataAccess.update(account, account.getAccountNumber(), StorageType.ACCOUNTS);
    }
}
