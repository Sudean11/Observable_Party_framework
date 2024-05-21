package com.miu.framework.common.Factory;

import com.miu.framework.common.Repositories.AccountDAO;
import com.miu.framework.common.Repositories.AccountDAOImpl;
import com.miu.framework.common.Repositories.PartyDAO;
import com.miu.framework.common.service.AccountService;

public class DAOAndServiceImpl implements DAOAndServiceFactory{
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }

    @Override
    public AccountService createAccountService() {
        return null;
    }

    @Override
    public PartyDAO createPartyDAO() {
        return null;
    }
}
