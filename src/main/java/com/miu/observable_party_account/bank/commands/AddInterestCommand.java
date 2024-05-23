package com.miu.observable_party_account.bank.commands;

import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.service.AccountService;

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
