package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class AddInterestCommand implements Command {
    AccountService accountService;

    public AddInterestCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Add Interest");
        accountService.deposit();
    }

    @Override
    public void undo() {
        accountService.withdraw();
    }
}
