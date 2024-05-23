package com.miu.observable_party_account.bank.observer;


import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.utils.enums.TransactionType;

import java.util.Objects;

public class EmailObserver implements Observer{

    private EmailObserver(){}

    private volatile static EmailObserver instance;

    public static EmailObserver getEmailObserver(){
        if(Objects.isNull(instance)){
            synchronized (EmailObserver.class){
                if(Objects.isNull(instance)){
                    instance = new EmailObserver();
                }
            }
        }
        return instance;
    }

    @Override
    public void update(Account account, double amount, TransactionType transactionType) {
        account.sendNotification(account, amount, transactionType);
    }
}
