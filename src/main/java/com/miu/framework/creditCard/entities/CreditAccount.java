package com.miu.framework.creditCard.entities;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.util.Date;

public class CreditAccount extends Account {

    public CreditAccount(String accountNumber, Party owner) {
        super(accountNumber, owner);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }
}
