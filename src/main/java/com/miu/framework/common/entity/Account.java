package com.miu.framework.common.entity;

public abstract class Account {
    private String accountNumber;
    private String name;
    private double amount;

    public Account(String accountNumber, String name, double amount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /*  Methods */
    public abstract void createAccount(String accountNumber, String name);

    public void withdraw(double amount) {

    }

    public void deposit(double amount) {}

    public abstract void addInterest();

    public void generateReport(){

    }
}
