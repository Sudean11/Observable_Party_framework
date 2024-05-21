package com.miu.framework.common.service;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankService implements AccountService{

    @Override
    public Account createAccount(String accountNumber, String name, double Amount) {
        return null;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return new ArrayList<>();
    }

    @Override
    public void deposit(String accountNumber, double amount) {

    }

    @Override
    public void withdraw(String accountNumber, double amount) {

    }

    @Override
    public void addInterest(String accountNumber) {

    }

    @Override
    public void deposit() {

    }
}
