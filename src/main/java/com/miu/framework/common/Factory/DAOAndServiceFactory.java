package com.miu.framework.common.Factory;

import com.miu.framework.common.Repositories.AccountDAO;
import com.miu.framework.common.Repositories.PartyDAO;
import com.miu.framework.common.service.AccountService;

public interface DAOAndServiceFactory {
    public abstract AccountDAO createAccountDAO();
    public abstract AccountService createAccountService();
    public abstract PartyDAO createPartyDAO();

    public AccountDAO createCreditCardAccountDAO();
    public PartyDAO createCreditCardPartyDAO();
}
