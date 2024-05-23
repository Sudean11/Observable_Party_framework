package com.miu.framework.creditCard.strategy;

import com.miu.framework.common.strategy.StrategyAccountType;

    public interface StrategyCreditCard extends StrategyAccountType {
    double getMonthlyInterest();

    double getMinimumPayment();

    public double getMinimumMonthlyPayment(double amount);
}
