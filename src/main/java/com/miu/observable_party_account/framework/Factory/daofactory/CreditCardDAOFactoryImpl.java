package com.miu.observable_party_account.framework.Factory.daofactory;

import com.miu.observable_party_account.framework.repositories.AccountDAO;
import com.miu.observable_party_account.framework.repositories.daoImpl.CreditCardDAOImpl;
import com.miu.observable_party_account.framework.repositories.daoImpl.CreditCardPartyDAO;
import com.miu.observable_party_account.framework.repositories.PartyDAO;

import java.util.Objects;

public class CreditCardDAOFactoryImpl implements DAOFactory{
    private volatile static CreditCardDAOFactoryImpl instance;
    public static CreditCardDAOFactoryImpl getCreditCardDAOFactory(){
        if(Objects.isNull(instance)){
            synchronized (CreditCardDAOFactoryImpl.class){
                if(Objects.isNull(instance)){
                    instance = new CreditCardDAOFactoryImpl();
                }
            }
        }
        return instance;
    }
    @Override
    public AccountDAO createAccountDAO() {
        return CreditCardDAOImpl.getAccountDAO();
    }

    @Override
    public PartyDAO createPartyDAO() {
        return CreditCardPartyDAO.getPartyDAO();

    }
}
