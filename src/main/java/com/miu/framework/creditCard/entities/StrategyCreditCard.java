package com.miu.framework.creditCard.entities;

import com.miu.framework.bank.entities.StrategyAccountType;

public interface StrategyCreditCard extends StrategyAccountType {
    public double getMinimumMonthlyPayment(double amount);
}
