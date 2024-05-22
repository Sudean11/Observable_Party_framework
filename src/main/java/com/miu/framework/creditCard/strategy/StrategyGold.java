package com.miu.framework.creditCard.strategy;

import com.miu.framework.common.utils.constants.InterestConstants;

public class StrategyGold implements StrategyCreditCard {

    @Override
    public double getMonthlyInterest() {
        return InterestConstants.GOLD_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumPayment() {
        return InterestConstants.GOLD_MONTHLY_PAYMENT/100;
    }

    @Override
    public double calculateInterest(double amount) {
        return amount* InterestConstants.GOLD_ACCOUNT_INTEREST/100;
    }
    @Override
    public double getMinimumMonthlyPayment(double amount){
        return amount* InterestConstants.GOLD_MONTHLY_PAYMENT/100;
    }

    @Override
    public void notifyUsers() {

    }
}
