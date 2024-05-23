package com.miu.observable_party_account.framework.strategy.strategyService;

import com.miu.observable_party_account.framework.Factory.daofactory.CreditCardDAOFactoryImpl;
import com.miu.observable_party_account.framework.service.AccountService;
import com.miu.observable_party_account.framework.service.AccountServiceImpl;

public class StrategyCreditCardService implements ServiceStrategy {
    @Override
    public AccountService getService() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(CreditCardDAOFactoryImpl.getCreditCardDAOFactory().createAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(CreditCardDAOFactoryImpl.getCreditCardDAOFactory().createPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }
}
