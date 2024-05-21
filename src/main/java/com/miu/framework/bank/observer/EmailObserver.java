package com.miu.framework.bank.observer;


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
    public void update(String email, String message) {
            System.out.println("EMAIL:" +email+" \n message: "+message);
    }
}
