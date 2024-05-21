package com.miu.framework.creditCard.Factory;

import com.miu.framework.creditCard.Repositories.AccountDAO;
import com.miu.framework.creditCard.Repositories.AccountDAOImpl;
import com.miu.framework.creditCard.Service.AccountService;

public class AccountDAOServiceImpl implements AccountDAOAndServiceFactory{
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }

    @Override
    public AccountService createAccountService() {
        return null;
    }
}
