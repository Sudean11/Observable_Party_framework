package com.miu.framework.bank.entities;

public interface StrategyAccountType {
    public double calculateInterest(double amount);
    void notifyUsers();
}
