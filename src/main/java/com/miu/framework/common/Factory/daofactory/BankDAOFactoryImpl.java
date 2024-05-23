package com.miu.framework.common.Factory.daofactory;

import com.miu.framework.common.repositories.*;

import java.util.Objects;

public class BankDAOFactoryImpl implements DAOFactory {
    private volatile static BankDAOFactoryImpl instance;
    public static BankDAOFactoryImpl getDAOService(){
        if(Objects.isNull(instance)){
            synchronized (BankDAOFactoryImpl.class){
                if(Objects.isNull(instance)){
                    instance = new BankDAOFactoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public AccountDAO createAccountDAO() {
        return AccountDAOImpl.getAccountDAO();
    }

    @Override
    public PartyDAO createPartyDAO() {
        return PartyDAOImpl.getPartyDAO();
    }

}
