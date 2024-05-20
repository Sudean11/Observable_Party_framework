package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Account;

import java.util.Date;

public abstract class CompanyBankAccount extends Account {

    private int numberOfEmployee;

    public CompanyBankAccount(String accountNumber, double amount, String street, String city, String state, String zip, int numberOfEmployee,String email) {
        super(accountNumber, amount, street, city, state, zip,email);
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public void createAccount(String accountNumber) {

    }

    @Override
    public void addInterest() {

    }


}
