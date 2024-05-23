package com.miu.framework.creditCard.Rule;

import com.miu.framework.common.Rule.Rule;
import com.miu.framework.common.entity.Account;
import com.miu.framework.creditCard.entities.CreditAccount;

class CreditLimitRule implements Rule {
    private String errorMessage;

    @Override
    public boolean isSatisfied(Account account, double amount) {
        if (account instanceof CreditAccount) {
            CreditAccount creditAccount = (CreditAccount) account;
            return creditAccount.getBalance() + amount <= creditAccount.getCardStrategy().getMinimumPayment();
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return "Credit limit exceeded.";
    }
}
