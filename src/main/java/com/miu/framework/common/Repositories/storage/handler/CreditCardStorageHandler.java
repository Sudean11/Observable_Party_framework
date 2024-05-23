package com.miu.framework.common.Repositories.storage.handler;

import com.miu.framework.common.Repositories.storage.StorageType;
import com.miu.framework.common.entity.Account;

public class CreditCardStorageHandler extends AbstractStorageHandler<Account> {
    @Override
    public StorageType getStorageType() {
        return StorageType.CREDIT_CARDS;
    }
}