package com.miu.framework.common.Rule;

import com.miu.framework.common.entity.Account;

public interface Rule {
    boolean isSatisfied(Account account, double amount);
    String getErrorMessage();
}
