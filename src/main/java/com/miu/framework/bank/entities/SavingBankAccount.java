package com.miu.framework.bank.entities;

public class SavingBankAccount extends CompanyBankAccount {
    public SavingBankAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void addInterest() {

    }
}
