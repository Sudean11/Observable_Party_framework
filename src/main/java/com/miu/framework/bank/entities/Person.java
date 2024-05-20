package com.miu.framework.bank.entities;

import java.util.List;

public class Person {
    private String name;
    private String email;
    List<BankAccount> bankAccountList;

    public Person(String name, String email, List<BankAccount> bankAccountList) {
        this.name = name;
        this.email = email;
        this.bankAccountList = bankAccountList;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<BankAccount> getAccountList() {
        return bankAccountList;
    }
}
