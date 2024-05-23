package com.miu.observable_party_account.creditCard.commands;

import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.receiver.ResultReceiver;
import com.miu.observable_party_account.framework.service.AccountService;

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
