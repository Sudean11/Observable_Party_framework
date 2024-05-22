package com.miu.framework.bank.commands;

import com.miu.framework.bank.ui.BankFrm;
import com.miu.framework.common.command.Command;
import com.miu.framework.common.receiver.ResultReceiver;
import com.miu.framework.common.service.AccountService;

public class TransactionHistoryCommand implements Command {
    private AccountService accountService;
    private String accountNumber;
    private ResultReceiver<String> resultReceiver;

    public TransactionHistoryCommand(AccountService accountService, String accountNumber, ResultReceiver<String> resultReceiver) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.resultReceiver = resultReceiver;
    }

    @Override
    public void execute() {
        String transactionHistory = accountService.getTransaction(accountNumber);
        resultReceiver.setResult(transactionHistory);
    }
}
