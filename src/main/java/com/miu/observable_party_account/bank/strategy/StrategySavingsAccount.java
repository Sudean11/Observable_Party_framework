package com.miu.observable_party_account.bank.strategy;

import com.miu.observable_party_account.framework.strategy.StrategyAccountType;
import com.miu.observable_party_account.framework.utils.constants.InterestConstants;

public class StrategySavingsAccount implements StrategyAccountType {
    private static final double INTEREST_RATE = InterestConstants.SAVINGS_ACCOUNT_INTEREST;

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE/100;
    }

}
