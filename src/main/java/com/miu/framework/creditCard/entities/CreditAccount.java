package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Account;

import java.util.Date;

public class CreditAccount extends Account {
    private Date birthdate;
    public CreditAccount(String accountNumber, double amount, String street, String city, String state, String zip, Date birthdate, String email) {
        super(accountNumber, amount, street, city, state, zip,email);
        this.birthdate = birthdate;
    }

    @Override
    public void createAccount(String accountNumber) {

    }

    @Override
    public void addInterest() {

    }
}
