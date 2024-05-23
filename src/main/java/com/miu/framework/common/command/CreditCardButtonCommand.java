package com.miu.framework.common.command;

import com.miu.framework.common.Factory.serviceFactory.CreditCardServiceFactory;
import com.miu.framework.creditCard.ui.CardFrm;

public class CreditCardButtonCommand implements Command {
    private CardFrm cardFrm;

    public CreditCardButtonCommand(CardFrm cardFrm) {
        this.cardFrm = cardFrm;
    }

    @Override
    public void execute() {
        new CreditCardServiceFactory().getService();
        cardFrm.setVisible(true);
    }
}
