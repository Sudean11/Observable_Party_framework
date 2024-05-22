package com.miu.framework.common.Factory;

import com.miu.framework.bank.observer.EmailObserver;
import com.miu.framework.common.Repositories.*;
import com.miu.framework.common.service.AccountService;

import java.util.Objects;

public class DAOAndServiceImpl implements DAOAndServiceFactory{


    private volatile static DAOAndServiceImpl instance;

    public static DAOAndServiceImpl getDAOService(){
        if(Objects.isNull(instance)){
            synchronized (DAOAndServiceImpl.class){
                if(Objects.isNull(instance)){
                    instance = new DAOAndServiceImpl();
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
    public AccountService createAccountService() {
        return null;
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
