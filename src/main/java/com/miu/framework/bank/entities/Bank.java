package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }


}
