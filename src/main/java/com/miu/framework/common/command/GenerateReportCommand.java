package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class GenerateReportCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Generate Report");
//        accountService.report();
    }

}
