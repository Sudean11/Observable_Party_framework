package com.miu.framework.creditCard.entities;

import com.miu.framework.bank.entities.AccountTypeStrategy;
import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.entities.TransactionType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;

public interface CreditCardStrategy extends AccountTypeStrategy {
    public double getMinimumMonthlyPayment(double amount);
}
