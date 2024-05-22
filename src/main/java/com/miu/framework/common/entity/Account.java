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
  public Party getOwner() {
        return owner;
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public abstract double calculateInterest(double amount);

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

