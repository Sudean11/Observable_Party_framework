package com.miu.framework.common.command;

import com.miu.framework.bank.entities.Transaction;
import com.miu.framework.bank.ui.BankFrm;
import com.miu.framework.bank.ui.JDialog_TransactionHistory;
import com.miu.framework.common.service.AccountService;

import javax.swing.*;
import java.util.List;

public class TransactionHistoryCommand implements Command {
    private BankFrm bankFrm;
    private AccountService accountService;
    private String accountNumber;

    public TransactionHistoryCommand(BankFrm bankFrm, AccountService accountService, String accountNumber) {
        this.bankFrm = bankFrm;
        this.accountService = accountService;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
//        List<Transaction> transactions = accountService.getTransactionHistory(accountNumber);
//        JDialog_TransactionHistory dialog = new JDialog_TransactionHistory(bankFrm, transactions);
//        dialog.setVisible(true);
    }
}
