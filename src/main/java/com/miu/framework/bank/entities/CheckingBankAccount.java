package com.miu.framework.bank.entities;

public class CheckingBankAccount extends CompanyBankAccount {
    public CheckingBankAccount(String accountNumber, Company company) {
        super(accountNumber, company);
    }

    @Override
    public void addInterest() {

    }
}
