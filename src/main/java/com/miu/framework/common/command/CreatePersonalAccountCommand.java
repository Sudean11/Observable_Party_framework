package com.miu.framework.common.command;

import com.miu.framework.bank.constants.BankAccountType;
import com.miu.framework.bank.entities.Person;
import com.miu.framework.bank.entities.StrategyAccountType;
import com.miu.framework.bank.entities.StrategyCheckingAccount;
import com.miu.framework.bank.entities.StrategySavingsAccount;
import com.miu.framework.common.service.AccountService;

public class CreatePersonalAccountCommand implements Command{
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
        bankService.createAccount(person, strategyAccountType, person.getAccountNumber());
    }
}
