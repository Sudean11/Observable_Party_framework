package com.miu.framework.common.Factory;

import com.miu.framework.common.service.AccountService;
import com.miu.framework.common.service.AccountServiceImpl;

import java.util.Objects;

public class ServiceFactoryImpl implements ServiceFactory{

    private volatile static ServiceFactoryImpl instance;

    public static ServiceFactoryImpl getAccountServiceForBankImpl(){
        if(Objects.isNull(instance)){
            synchronized (ServiceFactoryImpl.class){
                if(Objects.isNull(instance)){
                    instance = new ServiceFactoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public AccountService getAccountServiceReferencedBank() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(DAOFactoryImpl.getDAOService().createAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(DAOFactoryImpl.getDAOService().createPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }

    @Override
    public AccountService getAccountServiceReferencedCreditCard() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(DAOFactoryImpl.getDAOService().createCreditCardAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(DAOFactoryImpl.getDAOService().createCreditCardPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }
}
