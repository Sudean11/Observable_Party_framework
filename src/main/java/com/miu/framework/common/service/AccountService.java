package com.miu.framework.common.service;

import com.miu.framework.common.entity.Account;

import java.util.Collection;

public interface AccountService  {
    Account createAccount(String accountNumber,String name,double Amount);
    Account createAccount(String accountNumber,String name,double Amount,String email);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
}
