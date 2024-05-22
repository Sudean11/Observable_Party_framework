package com.miu.framework.common.entity;

import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.common.utils.enums.TransactionType;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Account {
    protected String accountNumber;
    protected double balance;
    protected Party owner;

    protected StrategyAccountType accountTypeStrategy;
    protected List<Transaction> transactionHistory = new ArrayList<>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public Party getOwner() {
        return owner;
    }

    public String getEmail(){
        return owner.getEmail();
    }

    public Account(String accountNumber, Party owner, StrategyAccountType accountTypeStrategy) {
        this.accountTypeStrategy = accountTypeStrategy;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(double amount){
        balance += amount;
        addTransaction(new Transaction(amount, TransactionType.DEPOSIT));
    };

    public void withdraw(double amount){
        balance -= amount;
        addTransaction(new Transaction(amount, TransactionType.WITHDRAWAL));
    };

    public double calculateInterest(double amount){
        return accountTypeStrategy.calculateInterest(amount);
    };

    public double getMinimumMonthlyPayment(double amount){
        throw new NoSuchMethodError();
    };

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
    public  String generateReport(){
        Month month= LocalDate.now().getMonth();
        Stream<Transaction> currentMonth=this.getTransactionHistory().stream().filter(f->f.getDate().getMonth()==month.getValue());
        double totalCredit=currentMonth.filter(f->f.getType().equals(TransactionType.WITHDRAWAL))
                .mapToDouble(m->m.getAmount())
                .reduce(0,(x,y)->x+y);
        double totalCharges=this.getTransactionHistory().stream().filter(f->f.getDate().getMonth()==month.getValue()).filter(f->f.getType().equals(TransactionType.DEPOSIT))
                .mapToDouble(m->m.getAmount())
                .reduce(0,(x,y)->x+y);
        double previousBalance=getBalance();
        double newBalance=previousBalance-totalCredit+totalCharges
                + accountTypeStrategy.getMonthlyInterest()*(previousBalance-totalCredit);
        double totalDue=accountTypeStrategy.getMinimumPayment()*newBalance;
        return "Account number :  "+accountNumber+"\t"+"\n"+"\t"+" - previous balance: "+balance+"\n" +
                "        - total charges: "+totalCharges+"\n" +
                "        - total credits: "+totalCredit+"\n" +
                "        - new balance = "+newBalance+"\n" +
                "        - total due = "+totalDue;
    }
}

