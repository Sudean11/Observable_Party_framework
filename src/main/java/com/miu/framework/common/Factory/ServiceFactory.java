package com.miu.framework.common.Factory;

import com.miu.framework.common.service.AccountService;

public interface ServiceFactory {
    AccountService getAccountServiceReferencedBank();
    AccountService getAccountServiceReferencedCreditCard();
}
