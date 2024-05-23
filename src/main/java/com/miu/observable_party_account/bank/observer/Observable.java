package com.miu.observable_party_account.bank.observer;

import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.utils.enums.TransactionType;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Account account, double amount, TransactionType transactionType);
}
