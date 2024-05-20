package com.miu.framework.bank.entities;

public class SavingBankAccount extends CompanyBankAccount {
    public SavingBankAccount(String accountNumber, Company company ) {
        super(accountNumber, company);
    }

    @Override
    public void addInterest() {

    }
}
