package com.miu.framework.bank.entities;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

public class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, Party owner) {
        super(accountNumber, owner);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction(amount, TransactionType.DEPOSIT));

    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        addTransaction(new Transaction(amount, TransactionType.DEPOSIT));

    }
}
