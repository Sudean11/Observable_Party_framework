package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Party;
import com.miu.framework.common.utils.Constants;

public class Gold extends CreditAccount{
    public Gold(String accountNumber, Party owner) {
        super(accountNumber, owner);
    }

    @Override
    public double calculateInterest(double amount) {
        return amount* Constants.GOLD_ACCOUNT_INTEREST/100;
    }
    @Override
    public double getMinimumMonthlyPayment(double amount){
        return amount*Constants.GOLD_MONTHLY_PAYMENT/100;
    }
}
