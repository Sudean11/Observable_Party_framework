package com.miu.observable_party_account.framework.command;

import com.miu.observable_party_account.framework.strategy.strategyService.StrategyCreditCardService;
import com.miu.observable_party_account.creditCard.ui.CardFrm;

public class CreditCardButtonCommand implements Command {
    private CardFrm cardFrm;

    public CreditCardButtonCommand(CardFrm cardFrm) {
        this.cardFrm = cardFrm;
    }

    @Override
    public void execute() {
        new StrategyCreditCardService().getService();
        cardFrm.setVisible(true);
    }
}
