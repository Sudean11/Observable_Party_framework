package com.miu.observable_party_account.framework.strategy.strategyService;

import com.miu.observable_party_account.framework.Factory.daofactory.CreditCardDAOFactoryImpl;
import com.miu.observable_party_account.framework.service.AccountService;
import com.miu.observable_party_account.framework.service.AccountServiceImpl;

public class StrategyCreditCardService implements ServiceStrategy {
    @Override
    public AccountService getService() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(new CreditCardDAOFactoryImpl().createAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(new CreditCardDAOFactoryImpl().createPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }
}
