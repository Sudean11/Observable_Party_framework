package com.miu.framework.bank.entities;

public abstract class Bank {
    public void addInterest(){



    }
    public void generateReport(){


    }
    public abstract void createPersonalAccount(String accountNumber, Person person);
    public abstract void createCompanyAccount(String accountNumber, Company company);
}
