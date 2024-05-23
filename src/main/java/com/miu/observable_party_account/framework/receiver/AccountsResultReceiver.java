package com.miu.observable_party_account.framework.receiver;

import com.miu.observable_party_account.framework.entity.Account;

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

