package com.miu.framework.creditCard.commands;

import com.miu.framework.common.command.Command;
import com.miu.framework.common.utils.enums.AccountType;
import com.miu.framework.creditCard.entities.*;
import com.miu.framework.common.service.AccountService;
import com.miu.framework.creditCard.strategy.StrategyBronze;
import com.miu.framework.creditCard.strategy.StrategyCreditCard;
import com.miu.framework.creditCard.strategy.StrategyGold;
import com.miu.framework.creditCard.strategy.StrategySilver;

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

        creditCardService.createAccount(person, strategyCreditCard, person.getAccountNumber());
    }
}
