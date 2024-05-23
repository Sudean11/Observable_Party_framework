package com.miu.framework.common.command;

import com.miu.framework.bank.ui.BankFrm;
import com.miu.framework.main.AppLauncher;

public class BankingButtonCommand implements Command{

    private BankFrm bankFrm;

    public BankingButtonCommand(BankFrm bankFrm) {
        this.bankFrm = bankFrm;
    }

    @Override
    public void execute() {
        bankFrm.setVisible(true);
        bankFrm.getAllCount_actionPerformed();
    }
}
