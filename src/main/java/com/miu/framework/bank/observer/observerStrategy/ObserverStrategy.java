package com.miu.framework.bank.observer.observerStrategy;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.utils.enums.TransactionType;

public interface ObserverStrategy {
    void notifyUser(Account account, double amount, TransactionType transactionType);
}
