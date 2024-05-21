package com.miu.framework.common.entity;

import com.miu.framework.bank.entities.Transaction;

import java.util.ArrayList;
import java.util.List;



public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected Party owner;
    protected List<Transaction> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, Party owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
}

