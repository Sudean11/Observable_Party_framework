package com.miu.framework.bank.observer;


import com.miu.framework.bank.entities.Person;
import com.miu.framework.common.entity.Account;

import java.util.Objects;

public class EmailObserver implements  Observer{

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
    public void update(Account account, double amount) {
        if(account.getOwner() instanceof Person){
            System.out.println("EMAIL:" +account.getEmail()+" \n Amount: "+amount);
        }else{
            if(amount > 500){
                System.out.println("EMAIL:" +account.getEmail()+" \n Amount: "+amount);
            }
        }
    }
}
