package com.miu.framework.bank.entities;

import java.util.Date;

public abstract class BankAccount {
    private String accountNumber;
    private double amount;
    private String street;
    private String city;
    private String state;
    private String zip;


    public BankAccount(String accountNumber, double amount, String street, String city, String state, String zip) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }

    public abstract void createAccount(String accountNumber);
    public void withdraw(double amount) {

    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }


    public void deposit(double amount) {

    }


    public abstract void addInterest();

    public void generateReport(){


    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
