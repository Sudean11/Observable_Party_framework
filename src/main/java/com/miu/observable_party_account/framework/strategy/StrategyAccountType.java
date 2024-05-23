package com.miu.observable_party_account.framework.strategy;

import com.miu.observable_party_account.framework.entity.Account;

public interface StrategyAccountType {

    public double calculateInterest(double amount);

    default double getMonthlyInterest(){
        return 0;
    };

    default double getMinimumPayment(){
        return 0;
    };
    public default String generateReport(Account account){
        return " Account Number  : "+account.getAccountNumber()+"\t"+"Account Balance = "+account.getBalance()
                +"\n"+" Interest = "+ account.getTransactionHistory()
                .stream().limit(5)
                .map(f->f.toString())
                .reduce("",(x,y)->x+"\n"+y)
                .toString();
    };
}
