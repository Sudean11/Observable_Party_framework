package com.miu.framework.bank.strategy;

import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.common.utils.constants.InterestConstants;

import java.io.Serializable;

public class StrategySavingsAccount implements StrategyAccountType, Serializable {
    private static final double INTEREST_RATE = InterestConstants.SAVINGS_ACCOUNT_INTEREST;

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE/100;
    }

}
