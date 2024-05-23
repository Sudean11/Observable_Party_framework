package com.miu.framework.bank.observer.observerStrategy;

import com.miu.framework.bank.entities.Company;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.utils.enums.TransactionType;

import java.io.Serializable;

public class CustomBankingStrategy implements ObserverStrategy, Serializable {

    @Override
    public void notifyUser(Account account, double amount, TransactionType transactionType) {
        if(account.getOwner() instanceof Company){
            System.out.println("********************************");
            System.out.println("EMAIL sent to Ac.No: "+ account.getAccountNumber()+ "\nAmount: "+amount);
            System.out.println("********************************");
            return;
        }

        if(account.getBalance() < amount){
            System.out.println("********************************");
            System.out.println("EMAIL sent to Ac.No: "+ account.getAccountNumber()+ "\nAmount: "+amount+ ": AMOUNT HIGHER THAN ACTUAL BALANCE");
            System.out.println("********************************");
        }

        if(amount>500){
            System.out.println("********************************");
            System.out.println("EMAIL sent to Ac.No: "+ account.getAccountNumber()+ "\nAmount: "+amount);
            System.out.println("********************************");
        }
    }
}
