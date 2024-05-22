package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Party;
import com.miu.framework.common.utils.Constants;

public class Silver implements CreditCardStrategy{

    @Override
    public double getMonthlyInterest() {
        return Constants.SILVER_ACCOUNT_INTEREST/100;
    }

    @Override
    public double getMinimumPayment() {
        return Constants.SILVER_MONTHLY_PAYMENT/100;
    }

    @Override
    public double calculateInterest(double amount) {
        return amount* Constants.SILVER_ACCOUNT_INTEREST/100;
    }
    @Override
    public double getMinimumMonthlyPayment(double amount){
        return amount*Constants.SILVER_MONTHLY_PAYMENT/100;
    }
    @Override
    public void notifyUsers() {

    }
}
