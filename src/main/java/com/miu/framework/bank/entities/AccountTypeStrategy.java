package com.miu.framework.bank.entities;

public interface AccountTypeStrategy {
    public double calculateInterest(double amount);
    void notifyUsers();
}
