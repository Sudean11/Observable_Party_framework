package com.miu.framework.bank.entities;

public class PersonalBankAccount extends BankAccount {
    private Person person;
    public PersonalBankAccount(String accountNumber, Person ownre) {
        super(accountNumber);
        person = ownre;
    }

    @Override
    public void addInterest() {

    }

    @Override
    public void notifyParties() {

    }
}
