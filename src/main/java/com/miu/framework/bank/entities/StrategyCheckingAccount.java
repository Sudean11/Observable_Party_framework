package com.miu.framework.bank.entities;

import com.miu.framework.common.utils.Constants;

public class StrategyCheckingAccount implements StrategyAccountType {
    @Override
    public double calculateInterest(double amount) {
        return amount * Constants.CHECKINGS_ACCOUNT_INTEREST/100;
    }

    @Override
    public void notifyUsers() {

    }
}
