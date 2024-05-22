package com.miu.framework.bank.entities;

import com.miu.framework.common.utils.enums.TransactionType;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private Date date;
    private double amount;
    private TransactionType type;
    private double previousBalance;

    private LocalDate localDate;

    public Transaction(double amount, TransactionType type, double balance, LocalDate localDate) {
        this.date = new Date();
        this.amount = amount;
        this.type = type;
        this.previousBalance = balance;
        this.localDate = localDate;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
    @Override
    public String toString(){
        return " Transaction Date  : "+date.toString()
                +"\t"+"Transaction Type  :  " +type.toString()
                +"\t"+"Amount  : "+amount;
    }

    public double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(double Balance) {
        this.previousBalance = Balance;
    }
}
