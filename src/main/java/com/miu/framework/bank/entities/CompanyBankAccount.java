package com.miu.framework.bank.entities;

import java.util.Date;

public abstract class CompanyBankAccount extends BankAccount {

    private int numberOfEmployee;

    public CompanyBankAccount(String accountNumber, double amount, String street, String city, String state, String zip, int numberOfEmployee) {
        super(accountNumber, amount, street, city, state, zip);
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public void createAccount(String accountNumber) {

    }

    @Override
    public void addInterest() {

    }


}
