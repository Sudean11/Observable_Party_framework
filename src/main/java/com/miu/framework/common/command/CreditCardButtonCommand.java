package com.miu.framework.common.command;

import com.miu.framework.bank.ui.BankFrm;
import com.miu.framework.common.Factory.ServiceFactoryImpl;
import com.miu.framework.creditCard.ui.CardFrm;

public class CreditCardButtonCommand implements Command {
    private CardFrm cardFrm;

    public CreditCardButtonCommand(CardFrm cardFrm) {
        this.cardFrm = cardFrm;
    }

    @Override
    public void execute() {
        ServiceFactoryImpl.getAccountServiceForBankImpl().getAccountServiceReferencedCreditCard();
        cardFrm.setVisible(true);
    }
}
