package com.miu.framework.common.Factory;

import com.miu.framework.common.Repositories.*;

import java.util.Objects;

public class DAOFactoryImpl implements DAOFactory {


    private volatile static DAOFactoryImpl instance;

    public static DAOFactoryImpl getDAOService(){
        if(Objects.isNull(instance)){
            synchronized (DAOFactoryImpl.class){
                if(Objects.isNull(instance)){
                    instance = new DAOFactoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }



    @Override
    public PartyDAO createPartyDAO() {
        return new PartyDAOImpl();
    }

    @Override
    public AccountDAO createCreditCardAccountDAO() {
        return new CreditCardDAOImpl();
    }

    @Override
    public PartyDAO createCreditCardPartyDAO() {
        return new CreditCardPartyDAO();
    }
}
