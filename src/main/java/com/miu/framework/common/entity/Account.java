package com.miu.framework.common.entity;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Account Class
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

