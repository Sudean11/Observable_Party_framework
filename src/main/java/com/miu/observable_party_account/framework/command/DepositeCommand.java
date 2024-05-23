package com.miu.observable_party_account.framework.command;

import com.miu.observable_party_account.framework.service.AccountService;

public class DepositeCommand implements Command {
    private AccountService bankService;
    private String accountNumber;
    private double amount;

    public DepositeCommand(AccountService accountService, String accountNumber, double amount){
        bankService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        System.out.println("Deposit Command to account no: "+accountNumber+" amount: "+amount);
        bankService.deposit(accountNumber, amount);
    }
}
