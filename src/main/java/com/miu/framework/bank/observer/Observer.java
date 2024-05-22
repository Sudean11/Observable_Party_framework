package com.miu.framework.bank.observer;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.utils.enums.TransactionType;

public interface Observer {
    void update(Account account, double amount, TransactionType transactionType);
}
