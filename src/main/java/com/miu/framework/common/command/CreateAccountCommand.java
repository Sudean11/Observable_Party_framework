package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class CreateAccountCommand implements Command{
    AccountService accountService;

    public CreateAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Create Account");
        accountService.createAccount();
    }

}
