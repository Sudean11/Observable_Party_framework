package com.miu.framework.common.Factory.serviceFactory;

import com.miu.framework.common.Factory.daofactory.CreditCardDAOFactoryImpl;
import com.miu.framework.common.service.AccountService;
import com.miu.framework.common.service.AccountServiceImpl;

public class CreditCardServiceFactory implements ServiceFactory{
    @Override
    public AccountService getService() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(new CreditCardDAOFactoryImpl().createAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(new CreditCardDAOFactoryImpl().createPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }
}
