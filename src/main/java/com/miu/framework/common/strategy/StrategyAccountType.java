package com.miu.framework.common.strategy;

public interface StrategyAccountType {
    public double calculateInterest(double amount);
    void notifyUsers();
}