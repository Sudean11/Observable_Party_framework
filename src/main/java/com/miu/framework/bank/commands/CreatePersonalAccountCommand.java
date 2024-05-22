package com.miu.framework.bank.commands;

import com.miu.framework.bank.observer.observerStrategy.CustomBankingStrategy;
import com.miu.framework.common.command.Command;
import com.miu.framework.common.utils.enums.BankAccountType;
import com.miu.framework.bank.entities.Person;
import com.miu.framework.common.strategy.StrategyAccountType;
import com.miu.framework.bank.strategy.StrategyCheckingAccount;
import com.miu.framework.bank.strategy.StrategySavingsAccount;
import com.miu.framework.common.service.AccountService;

public class CreatePersonalAccountCommand implements Command {
    AccountService bankService;
    Person person;

    public CreatePersonalAccountCommand(AccountService accountService, Person person) {
        this.bankService = accountService;
        this.person = person;
    }

    @Override
    public void execute() {
        StrategyAccountType strategyAccountType;
        if(person.getBankAccountType() == BankAccountType.CHECKING){
            strategyAccountType = new StrategyCheckingAccount();
        }else{
            strategyAccountType = new StrategySavingsAccount();
        }
        bankService.createAccount(person, strategyAccountType, person.getAccountNumber()).setObserverStrategy(new CustomBankingStrategy());
    }
}
