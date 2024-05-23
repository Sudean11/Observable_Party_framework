package com.miu.framework.common.Factory.daofactory;

import com.miu.framework.common.repositories.AccountDAO;
import com.miu.framework.common.repositories.CreditCardDAOImpl;
import com.miu.framework.common.repositories.CreditCardPartyDAO;
import com.miu.framework.common.repositories.PartyDAO;

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
