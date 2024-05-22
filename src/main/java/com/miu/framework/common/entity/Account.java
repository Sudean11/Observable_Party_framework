package com.miu.framework.common.entity;

import com.miu.framework.bank.entities.StrategyAccountType;
import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;

import java.util.ArrayList;
import java.util.List;



public class Account {
    protected String accountNumber;
    protected double balance;
    protected Party owner;

    protected StrategyAccountType accountTypeStrategy;
    protected List<Transaction> transactionHistory = new ArrayList<>();

    public Party getOwner() {
        return owner;
    }

    public String getEmail(){
        return owner.getEmail();
    }

    public Account(String accountNumber, Party owner, StrategyAccountType accountTypeStrategy) {
        this.accountTypeStrategy = accountTypeStrategy;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount){
        balance += amount;
        addTransaction(new Transaction(amount, TransactionType.DEPOSIT));
    };

    public void withdraw(double amount){
        balance -= amount;
        addTransaction(new Transaction(amount, TransactionType.WITHDRAWAL));
    };

    public double calculateInterest(double amount){
        return accountTypeStrategy.calculateInterest(amount);
    };

    public double getMinimumMonthlyPayment(double amount){
        throw new NoSuchMethodError();
    };

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
    public  String generateReport(){
        return " Account Number  : "+this.accountNumber+"\t"+"Account Balance = "+this.getBalance()
                +"\n"+" Interest = "+ this.getTransactionHistory()
                .stream().limit(5)
                .map(f->f.toString())
                .reduce("",(x,y)->x+"\n"+y)
                .toString();
    };
}

