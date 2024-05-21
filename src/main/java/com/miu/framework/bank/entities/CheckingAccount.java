package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;
import com.miu.framework.common.utils.Constants;

public class CheckingAccount implements AccountTypeStrategy {
    @Override
    public double calculateInterest(double amount) {
        return amount * Constants.CHECKINGS_ACCOUNT_INTEREST/100;
    }

    @Override
    public void notifyUsers() {

    }
}
