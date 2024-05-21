package com.miu.framework.bank.observer;

import com.miu.framework.common.entity.Account;

public interface Observer {
    void update(Account account, double amount);
}
