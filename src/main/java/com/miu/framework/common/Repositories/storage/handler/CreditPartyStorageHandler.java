package com.miu.framework.common.Repositories.storage.handler;

import com.miu.framework.common.Repositories.storage.StorageType;
import com.miu.framework.common.entity.Party;

public class CreditPartyStorageHandler extends AbstractStorageHandler<Party> {
    @Override
    public StorageType getStorageType() {
        return StorageType.CREDIT_PARTIES;
    }
}

