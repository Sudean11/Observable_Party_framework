package com.miu.framework.bank.entities;

import java.util.Date;

public class PersonalBankAccount extends BankAccount {
    private Date birthdate;

    public PersonalBankAccount(String accountNumber, double amount, String street, String city, String state, String zip, Date birthdate) {
        super(accountNumber, amount, street, city, state, zip);
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