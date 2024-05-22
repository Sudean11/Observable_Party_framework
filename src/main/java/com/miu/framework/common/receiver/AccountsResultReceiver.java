package com.miu.framework.common.receiver;

import com.miu.framework.common.entity.Account;

import java.util.Collection;

public class AccountsResultReceiver implements ResultReceiver<Collection<Account>> {
    private Collection<Account> accounts;

    @Override
    public void setResult(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public Collection<Account> getResult() {
        return accounts;
    }
}

