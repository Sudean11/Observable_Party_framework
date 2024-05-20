package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Account;

import java.util.Date;

public class PersonalBankAccount extends BankAccount {
    private Date birthdate;

    public PersonalBankAccount(String accountNumber, double amount, String street, String city, String state, String zip, Date birthdate, String email) {
        super(accountNumber, amount, street, city, state, zip,email);
        this.birthdate = birthdate;
    }

    @Override
    public void createAccount(String accountNumber) {

    }

    @Override
    public void addInterest() {

    }

    public Date getBirthdate() {
        return birthdate;
    }
}