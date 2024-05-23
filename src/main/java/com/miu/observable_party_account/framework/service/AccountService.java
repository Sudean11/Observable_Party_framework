package com.miu.observable_party_account.framework.service;

import com.miu.observable_party_account.framework.strategy.StrategyAccountType;
import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.entity.Party;

import java.util.Collection;

public interface AccountService  {
    Account createAccount(Party party, StrategyAccountType accountTypeStrategy, String accountNumber);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest();
    String generateReport();

    String getTransaction(String accountNumber);
}
