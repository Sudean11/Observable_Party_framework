package com.miu.observable_party_account.bank.observer.observerStrategy;

import com.miu.observable_party_account.bank.entities.Company;
import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.utils.enums.TransactionType;

public class CustomBankingStrategy implements ObserverStrategy{

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
