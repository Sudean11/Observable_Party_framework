package com.miu.framework.bank.observer;


import com.miu.framework.bank.entities.Company;
import com.miu.framework.bank.entities.Person;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.utils.enums.TransactionType;

import java.io.Serializable;
import java.util.Objects;

public class EmailObserver implements Observer, Serializable {

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
