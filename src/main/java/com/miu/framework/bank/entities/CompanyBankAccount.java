package com.miu.framework.bank.entities;
public abstract class CompanyBankAccount extends BankAccount {

    public CompanyBankAccount(String accountNumber) {
        super(accountNumber);
    }
    @Override
    public void createAccount(String accountNumber) {

    }

    @Override
    public void addInterest() {

    }


}
