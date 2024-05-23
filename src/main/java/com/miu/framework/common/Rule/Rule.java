package com.miu.framework.common.Rule;


import com.miu.observable_party_account.framework.entity.Account;

public interface Rule {
    boolean isSatisfied(Account account, double amount);
    String getErrorMessage();
}
