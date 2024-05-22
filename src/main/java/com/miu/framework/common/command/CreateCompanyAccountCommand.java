package com.miu.framework.common.command;

import com.miu.framework.bank.entities.Company;
import com.miu.framework.common.service.AccountService;

public class CreateCompanyAccountCommand implements Command {
    AccountService bankService;
    Company company;

    public CreateCompanyAccountCommand(AccountService accountService, Company company) {
        bankService = accountService;
        this.company = company;
    }

    @Override
    public void execute() {
        System.out.println("Creating Company Account");
    }


}
