package com.miu.framework.bank.entities;
public abstract class BankAccount {
    private String accountNumber;
    private double amount;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.amount = 0.0;
    }
    public abstract void createAccount(String accountNumber);
    public void withdraw(double amount) {

    }


    public void deposit(double amount) {

    }


    public abstract void addInterest();

    public void generateReport(){


    }


}
