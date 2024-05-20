package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Account;

public class CreditAccount extends Account {

    public CreditAccount(String accountNumber, String name, double amount) {
        super(accountNumber, name, amount);
    }

    @Override
    public void createAccount(String accountNumber, String name) {

    }

    @Override
    public void addInterest() {

    }
}
