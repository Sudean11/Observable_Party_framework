package com.miu.observable_party_account.bank.commands;

import com.miu.observable_party_account.bank.observer.observerStrategy.CustomBankingStrategy;
import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.utils.enums.BankAccountType;
import com.miu.observable_party_account.bank.entities.Person;
import com.miu.observable_party_account.framework.strategy.StrategyAccountType;
import com.miu.observable_party_account.bank.strategy.StrategyCheckingAccount;
import com.miu.observable_party_account.bank.strategy.StrategySavingsAccount;
import com.miu.observable_party_account.framework.service.AccountService;

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
