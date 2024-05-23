package com.miu.observable_party_account.creditCard.commands;

import com.miu.observable_party_account.bank.observer.observerStrategy.CustomCreditCardStrategy;
import com.miu.observable_party_account.framework.command.Command;
import com.miu.observable_party_account.framework.utils.enums.AccountType;
import com.miu.observable_party_account.creditCard.entities.*;
import com.miu.observable_party_account.framework.service.AccountService;
import com.miu.observable_party_account.creditCard.strategy.StrategyBronze;
import com.miu.observable_party_account.creditCard.strategy.StrategyCreditCard;
import com.miu.observable_party_account.creditCard.strategy.StrategyGold;
import com.miu.observable_party_account.creditCard.strategy.StrategySilver;

public class CreateCreditCardAccountCommand implements Command {

    AccountService creditCardService;
    Person person;

    public CreateCreditCardAccountCommand(AccountService accountService, Person person) {
        creditCardService = accountService;
        this.person = person;
    }

    @Override
    public void execute() {
        System.out.println("Creating Credit Card Account");
        StrategyCreditCard strategyCreditCard;
        if (person.getCreditAccountType() == AccountType.BRONZE){
            strategyCreditCard = new StrategyBronze();
        } else if (person.getCreditAccountType() == AccountType.GOLD) {
            strategyCreditCard = new StrategyGold();
        }else{
            strategyCreditCard = new StrategySilver();
        }
        creditCardService.createAccount(person, strategyCreditCard, person.getAccountNumber()).setObserverStrategy(new CustomCreditCardStrategy());
    }
}
