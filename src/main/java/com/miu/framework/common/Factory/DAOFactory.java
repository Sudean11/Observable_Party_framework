package com.miu.framework.common.Factory;

import com.miu.framework.common.Repositories.AccountDAO;
import com.miu.framework.common.Repositories.PartyDAO;

public interface DAOFactory {
    public abstract AccountDAO createAccountDAO();

    public abstract PartyDAO createPartyDAO();

    public AccountDAO createCreditCardAccountDAO();
    public PartyDAO createCreditCardPartyDAO();
}
