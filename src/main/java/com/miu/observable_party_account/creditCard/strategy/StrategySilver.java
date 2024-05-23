package com.miu.observable_party_account.creditCard.strategy;

import com.miu.observable_party_account.framework.utils.constants.InterestConstants;

public class StrategySilver implements StrategyCreditCard {

    @Override
    public double getMonthlyInterest() {
        return InterestConstants.SILVER_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumPayment() {
        return InterestConstants.SILVER_MONTHLY_PAYMENT/100;
    }

    @Override
    public double calculateInterest(double amount) {
        return amount* InterestConstants.SILVER_ACCOUNT_INTEREST/100;
    }
    @Override
    public double getMinimumMonthlyPayment(double amount){
        return amount* InterestConstants.SILVER_MONTHLY_PAYMENT/100;
    }

}
