package com.miu.framework.common.command;

public class WithdrawCommand implements Command {

    @Override
    public void execute() {
        System.out.println("withdraw command");
//        accountService.withdraw();
    }

}
