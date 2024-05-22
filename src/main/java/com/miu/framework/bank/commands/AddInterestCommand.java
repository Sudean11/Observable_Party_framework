package com.miu.framework.bank.commands;

import com.miu.framework.common.command.Command;
import com.miu.framework.common.service.AccountService;

public class AddInterestCommand implements Command {
    AccountService bankService;

    public AddInterestCommand(AccountService accountService) {
        this.bankService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Add Interest");
        bankService.addInterest();
    }
}
