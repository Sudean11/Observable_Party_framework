package com.miu.framework.creditCard.Factory;

import com.miu.framework.creditCard.Repositories.AccountDAO;
import com.miu.framework.creditCard.Service.AccountService;

public interface AccountDAOAndServiceFactory {
    public abstract AccountDAO createAccountDAO();
    public abstract AccountService createAccountService();
}
