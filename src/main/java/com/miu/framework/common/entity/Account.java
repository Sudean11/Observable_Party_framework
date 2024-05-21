package com.miu.framework.common.entity;

public abstract class Account {
    private String accountNumber;
    private double amount;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;


    public Account(String accountNumber, double amount, String street, String city, String state, String zip,String email) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;

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

    public String getEmail() {
        return email;
    }
}
