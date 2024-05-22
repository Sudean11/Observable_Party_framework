package com.miu.framework.creditCard.commands;

import com.miu.framework.common.command.Command;
import com.miu.framework.common.receiver.ResultReceiver;
import com.miu.framework.common.service.AccountService;

public class GenerateReportCommand implements Command {
    private AccountService creditCardService;
    private ResultReceiver<String> receiver;

    public GenerateReportCommand(AccountService accountService, ResultReceiver<String> receiver){
        this.creditCardService = accountService;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Generate Report");
        String report = creditCardService.generateReport();
        receiver.setResult(report);
    }

}
