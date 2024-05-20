package com.miu.framework.bank.entities;

public abstract class CompanyBankAccount extends BankAccount {
    Company company;
    public CompanyBankAccount(String accountNumber, Company company) {
        super(accountNumber);
        this.company = company;
    }
    @Override
    public void notifyParties() {

    }
}
