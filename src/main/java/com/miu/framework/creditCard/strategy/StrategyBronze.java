package com.miu.framework.creditCard.strategy;

import com.miu.framework.common.utils.constants.InterestConstants;

public class StrategyBronze implements StrategyCreditCard {

    @Override
    public double getMonthlyInterest() {
        return InterestConstants.BRONZE_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumPayment() {
        return InterestConstants.BRONZE_MONTHLY_PAYMENT/100;
    }

    @Override
    public double calculateInterest(double amount) {
        return amount* InterestConstants.BRONZE_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumMonthlyPayment(double amount){
        return amount* InterestConstants.BRONZE_MONTHLY_PAYMENT/100;
    }

}
