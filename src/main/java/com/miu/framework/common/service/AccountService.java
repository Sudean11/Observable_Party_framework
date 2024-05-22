package com.miu.framework.common.service;

import com.miu.framework.bank.entities.StrategyAccountType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.util.Collection;

public interface AccountService  {
    Account createAccount(Party party, StrategyAccountType accountTypeStrategy, String accountNumber);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
    String generateReport();
}
