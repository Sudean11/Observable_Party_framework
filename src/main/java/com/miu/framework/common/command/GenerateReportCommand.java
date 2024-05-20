package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class GenerateReportCommand implements Command{
    private AccountService accountService;

    public GenerateReportCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        accountService.report();
    }

    @Override
    public void undo() {
        System.out.println("No undo for report generation");
    }
}
