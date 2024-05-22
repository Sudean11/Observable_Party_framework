package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class GenerateReportCommand implements Command{
    private AccountService creditCardService;

    public GenerateReportCommand(AccountService accountService){
        this.creditCardService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Generate Report");
//        creditCardService.generateReport();
    }

}
