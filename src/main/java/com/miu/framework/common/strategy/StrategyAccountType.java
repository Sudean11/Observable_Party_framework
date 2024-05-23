package com.miu.framework.common.strategy;

public interface StrategyAccountType {

    public double calculateInterest(double amount);

    default double getMonthlyInterest(){
        return 0;
    };

    default double getMinimumPayment(){
        return 0;
    };
}
