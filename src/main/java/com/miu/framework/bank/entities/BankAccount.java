package com.miu.framework.bank.entities;

public abstract class BankAccount {
    private String accountNumber;
    private double amount;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.amount = 0.0;
    }

    public void withdraw(double amount) {



        notifyParties();
    }

    public void deposit(double amount) {



        notifyParties();
    }

    public abstract void addInterest();

    public abstract void notifyParties();

}
