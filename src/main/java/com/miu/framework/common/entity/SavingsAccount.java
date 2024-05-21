package com.miu.framework.common.entity;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.02;

    public SavingsAccount(String accountNumber, Party owner) {
        super(accountNumber, owner);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction(amount, TransactionType.DEPOSIT ));

    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        addTransaction(new Transaction(amount, TransactionType.WITHDRAWAL));

    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        deposit(interest);
    }


}
