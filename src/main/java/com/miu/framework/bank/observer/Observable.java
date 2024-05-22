package com.miu.framework.bank.observer;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.utils.enums.TransactionType;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Account account, double amount, TransactionType transactionType);
}
