package com.miu.observable_party_account.framework.command;

import com.miu.observable_party_account.bank.ui.BankFrm;
import com.miu.observable_party_account.framework.strategy.strategyService.StrategyBankService;

public class BankingButtonCommand implements Command{

    private BankFrm bankFrm;

    public BankingButtonCommand(BankFrm bankFrm) {
        this.bankFrm = bankFrm;
    }

    @Override
    public void execute() {
        new StrategyBankService().getService();
        bankFrm.setVisible(true);

    }
}
