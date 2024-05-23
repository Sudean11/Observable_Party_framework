package com.miu.observable_party_account.bank.commands;

import com.miu.observable_party_account.bank.observer.observerStrategy.CustomBankingStrategy;
import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.utils.enums.BankAccountType;
import com.miu.observable_party_account.bank.entities.Company;
import com.miu.observable_party_account.framework.strategy.StrategyAccountType;
import com.miu.observable_party_account.bank.strategy.StrategyCheckingAccount;
import com.miu.observable_party_account.bank.strategy.StrategySavingsAccount;
import com.miu.observable_party_account.framework.service.AccountService;

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
        bankService.createAccount(company, strategyAccountType, company.getAccountNumber()).setObserverStrategy(new CustomBankingStrategy());
    }


}
