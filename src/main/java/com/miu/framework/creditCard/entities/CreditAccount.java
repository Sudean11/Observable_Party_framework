package com.miu.framework.creditCard.entities;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class CreditAccount extends Account {
    StrategyCreditCard cardStrategy;
    public CreditAccount(String accountNumber, Party owner,StrategyCreditCard cardStrategy) {
        super(accountNumber, owner,cardStrategy);
        this.cardStrategy=cardStrategy;
    }

    @Override
    public void deposit(double amount) {

    }
    @Override
    public void withdraw(double amount) {

    }

    public abstract double calculateInterest(double amount);


    /*
      * - previous balance: balance from last month
        - total charges: total of all charges for this month
        - total credits: total of all payments for this month
        - new balance = previous balance – total credits + total charges + MI * (previous balance-total credits)
        - total due = MP * new balance
      * */
    @Override
    public String generateReport(){
     Month month= LocalDate.now().getMonth();
        Stream<Transaction> currentMonth=this.getTransactionHistory().stream().filter(f->f.getDate().getMonth()==month.getValue());
        double totalCredit=currentMonth.filter(f->f.getType().equals(TransactionType.WITHDRAWAL))
                                       .mapToDouble(m->m.getAmount())
                                       .reduce(0,(x,y)->x+y);
        double totalCharges=currentMonth.filter(f->f.getType().equals(TransactionType.DEPOSIT))
                .mapToDouble(m->m.getAmount())
                .reduce(0,(x,y)->x+y);
        double previousBalance=getBalance();
        double newBalance=previousBalance-totalCredit+totalCharges
                          + cardStrategy.getMonthlyInterest()*(previousBalance-totalCredit);
        double totalDue=cardStrategy.getMinimumPayment()*newBalance;
        return "Account number :  "+accountNumber+"\t"+"\n"+"\t"+" - previous balance: "+balance+"\n" +
                "        - total charges: "+totalCharges+"\n" +
                "        - total credits: "+totalCredit+"\n" +
                "        - new balance = "+newBalance+"\n" +
                "        - total due = "+totalDue;
    }
}
