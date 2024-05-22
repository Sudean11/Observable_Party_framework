package com.miu.framework.bank.commands;

import com.miu.framework.common.command.Command;
import com.miu.framework.common.utils.enums.BankAccountType;
import com.miu.framework.bank.entities.Company;
import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.bank.strategy.StrategyCheckingAccount;
import com.miu.framework.bank.strategy.StrategySavingsAccount;
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
