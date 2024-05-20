package com.miu.framework.bank.entities;

import java.util.Date;

public class CheckingBankAccount extends CompanyBankAccount {


    public CheckingBankAccount(String accountNumber, double amount, String street, String city, String state, String zip, int numberOfEmployee) {
        super(accountNumber, amount, street, city, state, zip, numberOfEmployee);
    }

    @Override
    public void addInterest() {

    }
}
