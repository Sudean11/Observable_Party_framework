package com.miu.framework.common.command;

import com.miu.framework.creditCard.entities.Person;
import com.miu.framework.common.service.AccountService;

public class CreateCreditCardAccountCommand implements Command{

    AccountService creditCardService;
    Person person;

    public CreateCreditCardAccountCommand(AccountService accountService, Person person) {
        creditCardService = accountService;
        this.person = person;
    }

    @Override
    public void execute() {
        System.out.println("Creating Credit Card Account");
    }
}
