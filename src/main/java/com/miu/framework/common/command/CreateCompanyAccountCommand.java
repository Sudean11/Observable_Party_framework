package com.miu.framework.common.command;

import com.miu.framework.bank.constants.BankAccountType;
import com.miu.framework.bank.entities.Company;
import com.miu.framework.bank.entities.StrategyAccountType;
import com.miu.framework.bank.entities.StrategyCheckingAccount;
import com.miu.framework.bank.entities.StrategySavingsAccount;
import com.miu.framework.common.service.AccountService;

public class CreateCompanyAccountCommand implements Command {
    AccountService bankService;
    Company company;

    public CreateCompanyAccountCommand(AccountService accountService, Company company) {
        bankService = accountService;
        this.company = company;
    }

    @Override
    public void execute() {
        System.out.println("Creating Company Account");
        StrategyAccountType strategyAccountType;
        if(company.getBankAccountType() == BankAccountType.CHECKING){
            strategyAccountType = new StrategyCheckingAccount();
        }else{
            strategyAccountType = new StrategySavingsAccount();
        }
        bankService.createAccount(company, strategyAccountType, company.getAccountNumber());
    }


}
