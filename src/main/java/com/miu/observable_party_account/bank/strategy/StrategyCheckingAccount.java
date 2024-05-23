package com.miu.observable_party_account.bank.strategy;

import com.miu.observable_party_account.framework.strategy.StrategyAccountType;
import com.miu.observable_party_account.framework.utils.constants.InterestConstants;

public class StrategyCheckingAccount implements StrategyAccountType {
    @Override
    public double calculateInterest(double amount) {
        return amount * InterestConstants.CHECKINGS_ACCOUNT_INTEREST/100;
    }


}
