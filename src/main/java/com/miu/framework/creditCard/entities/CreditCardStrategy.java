package com.miu.framework.creditCard.entities;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

public interface CreditCardStrategy  {
    double getMonthlyInterest();

    double getMinimumPayment();

    public double getMinimumMonthlyPayment(double amount);
}
