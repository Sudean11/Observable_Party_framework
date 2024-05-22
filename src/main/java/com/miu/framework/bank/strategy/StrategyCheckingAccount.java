package com.miu.framework.bank.strategy;

import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.common.utils.constants.InterestConstants;

public class StrategyCheckingAccount implements StrategyAccountType {
    @Override
    public double calculateInterest(double amount) {
        return amount * InterestConstants.CHECKINGS_ACCOUNT_INTEREST/100;
    }

    @Override
    public void notifyUsers() {

    }
}
