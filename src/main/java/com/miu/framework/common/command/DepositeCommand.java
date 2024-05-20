package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class DepositeCommand implements Command {
    private AccountService accountService;

    public DepositeCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        accountService.deposit();
    }

    @Override
    public void undo() {
        accountService.withdraw();
    }
}
