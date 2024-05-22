package com.miu.framework.creditCard.entities;

import com.miu.framework.bank.entities.StrategyAccountType;
import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

public interface StrategyCreditCard extends StrategyAccountType {
    double getMonthlyInterest();

    double getMinimumPayment();

    public double getMinimumMonthlyPayment(double amount);
}
