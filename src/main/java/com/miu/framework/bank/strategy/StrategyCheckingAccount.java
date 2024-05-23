package com.miu.framework.bank.strategy;

import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.common.utils.constants.InterestConstants;

import java.io.Serializable;

public class StrategyCheckingAccount implements StrategyAccountType, Serializable {
    @Override
    public double calculateInterest(double amount) {
        return amount * InterestConstants.CHECKINGS_ACCOUNT_INTEREST/100;
    }


}
