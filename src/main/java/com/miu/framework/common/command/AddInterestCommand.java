package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class AddInterestCommand implements Command {
    AccountService accountService;
    private String accountNumber;

    public AddInterestCommand(AccountService accountService, String accountNumber) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute() {
        System.out.println("Add Interest");
        accountService.addInterest();
    }

   public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
   }
}
