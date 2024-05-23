package com.miu.framework.common.strategy;

import com.miu.framework.common.entity.Account;

public interface StrategyAccountType {

    public double calculateInterest(double amount);

    default double getMonthlyInterest(){
        return 0;
    };

    default double getMinimumPayment(){
        return 0;
    };
    public default String generateReport(Account account){
        System.out.println("Infos: "+account.getEmail());
        return " Account Number  : "+account.getAccountNumber()+"\t"+"Account Balance = "+account.getBalance()
                +"\n"+" Interest = "+ account.getTransactionHistory()
                .stream().limit(5)
                .map(f->f.toString())
                .reduce("",(x,y)->x+"\n"+y);
    };
}
