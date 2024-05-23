package com.miu.framework.common.command;

import com.miu.framework.bank.ui.BankFrm;
import com.miu.framework.common.Factory.serviceFactory.BankServiceFactory;

public class BankingButtonCommand implements Command{

    private BankFrm bankFrm;

    public BankingButtonCommand(BankFrm bankFrm) {
        this.bankFrm = bankFrm;
    }

    @Override
    public void execute() {
        new BankServiceFactory().getService();
        bankFrm.setVisible(true);

    }
}
