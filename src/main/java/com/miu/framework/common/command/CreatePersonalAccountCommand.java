package com.miu.framework.common.command;

import com.miu.framework.common.constants.BankAccountType;
import com.miu.framework.common.service.AccountService;

public class CreatePersonalAccountCommand implements Command{
    AccountService accountService;
    String accountNumber;
    String clientName;
    String street;
    String city;
    String state;
    String zip;
    String dob;
    String email;
    BankAccountType bankAccountType;

    public CreatePersonalAccountCommand(AccountService accountService,
                                        String accountNumber,
                                        String clientName,
                                        String street,
                                        String city,
                                        String state,
                                        String zip,
                                        String dob,
                                        String email,
                                        BankAccountType bankAccountType) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Creating Personal Account");
//        accountService.createAccount();
    }
}
