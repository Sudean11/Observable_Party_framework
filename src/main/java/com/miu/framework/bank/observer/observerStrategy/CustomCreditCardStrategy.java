package com.miu.framework.bank.observer.observerStrategy;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.utils.enums.TransactionType;

public class CustomCreditCardStrategy implements ObserverStrategy{

    @Override
    public void notifyUser(Account account, double amount, TransactionType transactionType) {
        if(amount > 400){
            System.out.println("********************************");
            System.out.println("EMAIL sent to Ac.No: "+ account.getAccountNumber()+ "\n Amount: "+amount);
            System.out.println("********************************");
        }
    }
}
