package com.miu.framework.bank.entities;

import com.miu.framework.common.utils.Constants;

public class StrategySavingsAccount implements StrategyAccountType {
    private static final double INTEREST_RATE = Constants.SAVINGS_ACCOUNT_INTEREST;

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE/100;
    }
    @Override
    public void notifyUsers() {

    }
}
