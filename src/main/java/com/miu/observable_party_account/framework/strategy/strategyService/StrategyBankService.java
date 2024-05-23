package com.miu.observable_party_account.framework.strategy.strategyService;

import com.miu.observable_party_account.framework.Factory.daofactory.BankDAOFactoryImpl;
import com.miu.observable_party_account.framework.service.AccountService;
import com.miu.observable_party_account.framework.service.AccountServiceImpl;

public class StrategyBankService implements ServiceStrategy {
    @Override
    public AccountService getService() {
        AccountServiceImpl.getAccountServiceForBankImpl().setAccountDAO(BankDAOFactoryImpl.getDAOService().createAccountDAO());
        AccountServiceImpl.getAccountServiceForBankImpl().setPartyDAO(BankDAOFactoryImpl.getDAOService().createPartyDAO());
        return AccountServiceImpl.getAccountServiceForBankImpl();
    }
}
