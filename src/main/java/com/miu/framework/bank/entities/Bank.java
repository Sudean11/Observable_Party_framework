package com.miu.framework.bank.entities;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addInterest() {
        for (Account account : accounts) {
            //account.addInterest();
        }
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Account account : accounts) {
            report.append(account.toString()).append("\n");
        }
        return report.toString();
    }
}
