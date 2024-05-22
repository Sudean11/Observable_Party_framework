package com.miu.framework.creditCard.entities;

import com.miu.framework.common.utils.Constants;

public class StrategyBronze implements StrategyCreditCard {

    @Override
    public double getMonthlyInterest() {
        return Constants.BRONZE_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumPayment() {
        return Constants.BRONZE_MONTHLY_PAYMENT/100;
    }

    @Override
    public double calculateInterest(double amount) {
        return amount* Constants.BRONZE_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumMonthlyPayment(double amount){
        return amount*Constants.BRONZE_MONTHLY_PAYMENT/100;
    }

    @Override
    public void notifyUsers() {

    }
}
