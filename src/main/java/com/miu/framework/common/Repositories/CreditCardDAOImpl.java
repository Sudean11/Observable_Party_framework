package com.miu.framework.common.Repositories;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreditCardDAOImpl implements AccountDAO{
    List<Account> creditCards;
    public void  save(Account account){
        creditCards.add(account);
    };
    public void updateAccount(Account account){
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            creditCards.remove(accountexist);
            creditCards.add(account);
        }
    };
    public Account loadAccount(String accountnumber){
        for (Account account : creditCards) {
            if (Objects.equals(account.getAccountNumber(), accountnumber)) {
                return account;
            }
        }
        return null;
    };
    public List<Account> getAccounts(){
        return creditCards;
    }

    @Override
    public void saveAccount(Account account) {
        creditCards.add(account);
    }

    @Override
    public void removeAccount(Account account) {
        creditCards.remove(account);
    }
    public CreditCardDAOImpl(){
        this.creditCards = new ArrayList<>();
    }


}
