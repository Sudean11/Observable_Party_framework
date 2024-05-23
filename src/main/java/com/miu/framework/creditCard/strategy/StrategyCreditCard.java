package com.miu.framework.creditCard.strategy;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.common.utils.enums.TransactionType;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.stream.Stream;

public interface StrategyCreditCard extends StrategyAccountType {
    double getMonthlyInterest();

    double getMinimumPayment();

    public double getMinimumMonthlyPayment(double amount);
    @Override
    public default String generateReport(Account account) {
        Month month= LocalDate.now().getMonth();
        Month prvMonth=month.minus(1);
        double prvMonthBalance=account.getTransactionHistory().stream()
                .filter(f->f.getDate().getMonth()== prvMonth.getValue())
                .sorted(Comparator.comparing(Transaction::getDate)).findFirst().get().getPreviousBalance();
        Stream<Transaction> currentMonth=account.getTransactionHistory().stream()
                .filter(f->f.getDate().getMonth()== month.getValue());
        Stream<Transaction> withdraws=account.getTransactionHistory().stream()
                .filter(f->f.getType().equals(TransactionType.WITHDRAWAL));
        Stream<Transaction> deposits=account.getTransactionHistory().stream()
                .filter(f->f.getType().equals(TransactionType.DEPOSIT));
        double totalCredit=withdraws
                .mapToDouble(m->m.getAmount())
                .reduce(0,(x,y)->x+y);
        double totalCharges=deposits
                .mapToDouble(m->m.getAmount())
                .reduce(0,(x,y)->x+y);
        double previousBalance=prvMonthBalance;
        double newBalance=previousBalance-totalCredit+totalCharges
                + getMonthlyInterest()*(previousBalance-totalCredit);
        double totalDue=getMinimumPayment()*newBalance;
        return "         - Account number :  "+account.getAccountNumber()+"\t"+"\n"+
                "        - Previous balance: "+previousBalance+"\n" +
                "        - Total charges: "+totalCharges+"\n" +
                "        - Total credits: "+totalCredit+"\n" +
                "        - New balance = "+newBalance+"\n" +
                "        - Total due = "+totalDue;
    }

}
