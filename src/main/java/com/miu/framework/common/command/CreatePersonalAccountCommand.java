package com.miu.framework.common.command;

import com.miu.framework.bank.entities.Person;
import com.miu.framework.bank.entities.StrategyCheckingAccount;
import com.miu.framework.common.service.AccountService;

public class CreatePersonalAccountCommand implements Command{
    AccountService accountService;
    Person person;

    public CreatePersonalAccountCommand(AccountService accountService, Person person) {
        this.accountService = accountService;
        this.person = person;
    }

    @Override
    public void execute() {
        System.out.println("Creating Personal Account");

        accountService.createAccount(person, new StrategyCheckingAccount(),"sdfasd");
    }
}
