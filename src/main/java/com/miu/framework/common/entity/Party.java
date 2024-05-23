package com.miu.framework.common.entity;

import com.miu.framework.bank.observer.observerStrategy.ObserverStrategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Party implements Serializable {

    protected String name;
    protected String email;
    protected List<Account> accounts = new ArrayList<>();

    public Party(String name, String email, String s) {
        this.name = name;
        this.email = email;
    }



    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getEmail() {
        return email;
    }

    public String getName(){
        return name;
    }

    public String getCity(){
        throw new UnsupportedOperationException();
    }
    public String getAccountType(){
        throw new UnsupportedOperationException();
    }

    public String getAccountOwnerType(){
        throw new UnsupportedOperationException();
    }

    public String getExpDate(){
        throw new UnsupportedOperationException();
    }
}


