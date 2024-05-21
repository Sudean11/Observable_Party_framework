package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;
import com.miu.framework.common.utils.Constants;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = Constants.SAVINGS_ACCOUNT_INTEREST;
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

    @Override
    public double calculateInterest(double amount) {
        return balance * INTEREST_RATE/100;
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        deposit(interest);
    }


}
