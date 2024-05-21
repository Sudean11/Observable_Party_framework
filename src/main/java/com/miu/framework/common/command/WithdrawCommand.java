package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class WithdrawCommand implements Command {
    private AccountService accountService;

    public WithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("withdraw command");
        accountService.withdraw();
    }

    @Override
    public void undo() {
        accountService.deposit();
    }
}
