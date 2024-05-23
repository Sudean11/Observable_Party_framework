package com.miu.observable_party_account.framework.Factory.daofactory;

import com.miu.observable_party_account.framework.repositories.AccountDAO;
import com.miu.observable_party_account.framework.repositories.CreditCardDAOImpl;
import com.miu.observable_party_account.framework.repositories.CreditCardPartyDAO;
import com.miu.observable_party_account.framework.repositories.PartyDAO;

public class CreditCardDAOFactoryImpl implements DAOFactory{
    @Override
    public AccountDAO createAccountDAO() {
        return CreditCardDAOImpl.getAccountDAO();
    }

    @Override
    public PartyDAO createPartyDAO() {
        return CreditCardPartyDAO.getPartyDAO();

    }
}
