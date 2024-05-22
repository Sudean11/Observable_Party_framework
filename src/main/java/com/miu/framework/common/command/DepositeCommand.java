package com.miu.framework.common.command;

import com.miu.framework.common.service.AccountService;

public class DepositeCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Deposite Command");
    }
}
