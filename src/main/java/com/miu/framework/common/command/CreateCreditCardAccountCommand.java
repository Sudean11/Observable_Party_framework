package com.miu.framework.common.command;

import com.miu.framework.common.constants.BankAccountType;
import com.miu.framework.common.service.AccountService;

public class CreateCreditCardAccountCommand implements Command{

    AccountService creditCardService;
    String accountNumber;
    String clientName;
    String street;
    String city;
    String state;
    String zip;
    String dob;
    String email;
    BankAccountType bankAccountType;

    public CreateCreditCardAccountCommand(AccountService accountService,
                                        String accountNumber,
                                        String clientName,
                                        String street,
                                        String city,
                                        String state,
                                        String zip,
                                        String dob,
                                        String email,
                                        BankAccountType bankAccountType) {
        creditCardService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Creating Credit Card Account");
    }
}
