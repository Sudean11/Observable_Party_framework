package com.miu.framework.common.Factory;

import com.miu.framework.common.service.AccountService;
import com.miu.framework.common.service.AccountServiceImpl;

import java.util.Objects;
public class ServiceFactoryImpl implements ServiceFactory {

    private volatile static ServiceFactoryImpl bankInstance;
    private volatile static ServiceFactoryImpl creditCardInstance;

    public static ServiceFactoryImpl getBankServiceFactory() {
        if (Objects.isNull(bankInstance)) {
            synchronized (ServiceFactoryImpl.class) {
                if (Objects.isNull(bankInstance)) {
                    bankInstance = new ServiceFactoryImpl();
                }
            }
        }
        return bankInstance;
    }

    public static ServiceFactoryImpl getCreditCardServiceFactory() {
        if (Objects.isNull(creditCardInstance)) {
            synchronized (ServiceFactoryImpl.class) {
                if (Objects.isNull(creditCardInstance)) {
                    creditCardInstance = new ServiceFactoryImpl();
                }
            }
        }
        return creditCardInstance;
    }

    @Override
    public AccountService getAccountServiceReferencedBank() {
        AccountServiceImpl accountService = AccountServiceImpl.getBankServiceFactory();
        accountService.setAccountDAO(DAOFactoryImpl.getDAOService().createAccountDAO());
        accountService.setPartyDAO(DAOFactoryImpl.getDAOService().createPartyDAO());
        return accountService;
    }

    @Override
    public AccountService getAccountServiceReferencedCreditCard() {
        AccountServiceImpl accountService = AccountServiceImpl.getCreditCardServiceFactory();
        accountService.setAccountDAO(DAOFactoryImpl.getDAOService().createCreditCardAccountDAO());
        accountService.setPartyDAO(DAOFactoryImpl.getDAOService().createCreditCardPartyDAO());
        return accountService;
    }
}

