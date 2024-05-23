package com.miu.framework.common.Factory.serviceFactory;

import com.miu.framework.common.Factory.daofactory.BankDAOFactoryImpl;
import com.miu.framework.common.service.AccountService;
import com.miu.framework.common.service.AccountServiceImpl;

public class BankServiceFactory implements ServiceFactory {
    @Override
    public AccountService getService() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(BankDAOFactoryImpl.getDAOService().createAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(BankDAOFactoryImpl.getDAOService().createPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }
}
