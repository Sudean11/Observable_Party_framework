package com.miu.framework.Rule;

import com.miu.framework.common.Rule.Rule;
import com.miu.observable_party_account.framework.entity.Account;

public class MinimumBalanceRule implements Rule {
    private double minimumBalance;
    private String errorMessage;

    public MinimumBalanceRule(double minimumBalance) {
        this.minimumBalance = minimumBalance;
        this.errorMessage = "Balance must not fall below " + minimumBalance;
    }

    @Override
    public boolean isSatisfied(Account account, double amount) {
        return false;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}