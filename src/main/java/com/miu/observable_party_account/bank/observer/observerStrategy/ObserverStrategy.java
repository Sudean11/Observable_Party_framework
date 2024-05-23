package com.miu.observable_party_account.bank.observer.observerStrategy;

import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.utils.enums.TransactionType;

public interface ObserverStrategy {
    void notifyUser(Account account, double amount, TransactionType transactionType);
}
