package com.miu.framework.common.command;

import com.miu.framework.common.constants.BankAccountType;
import com.miu.framework.common.entity.Account;
import com.miu.framework.common.entity.Party;
import com.miu.framework.common.service.AccountService;

public class CreateCompanyAccountCommand implements Command {
    AccountService bankService;
    String accountNumber;
    String clientName;
    String street;
    String city;
    String state;
    String zip;
    int numberOfEmployees;
    String email;
    BankAccountType bankAccountType;


    public CreateCompanyAccountCommand(AccountService accountService,
                                       String accountNumber,
                                       String clientName,
                                       String street,
                                       String city,
                                       String state,
                                       String zip,
                                       int numberOfEmployees,
                                       String email,
                                       BankAccountType bankAccountType) {
        bankService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Creating Company Account");
//        new Party();
//        new Account();
    }


}
