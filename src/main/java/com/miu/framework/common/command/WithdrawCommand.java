package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class WithdrawCommand implements Command {
    private AccountService bankService;
    private String accountNumber;
    private double amount;

    public WithdrawCommand(AccountService accountService, String accountNumber, double amount){
        this.bankService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        System.out.println("withdraw command");
        bankService.withdraw(accountNumber, amount);
    }

}
