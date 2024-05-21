package com.miu.framework.common.command;

public class WithdrawCommand implements Command {
    private AccountService accountService;

    public WithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("withdraw command");
        accountService.withdraw();
    }

}
