package com.miu.observable_party_account.bank.commands;

import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.receiver.ResultReceiver;
import com.miu.observable_party_account.framework.service.AccountService;

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
