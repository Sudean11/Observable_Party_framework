package com.miu.framework.common.command;

import com.miu.framework.common.entity.Account;
import com.miu.framework.common.receiver.ResultReceiver;
import com.miu.framework.common.service.AccountService;

import java.util.Collection;

public class GetAllAccountsCommand implements Command {
    private AccountService accountService;
    private ResultReceiver<Collection<Account>> receiver;

    public GetAllAccountsCommand(AccountService accountService, ResultReceiver<Collection<Account>> receiver) {
        this.accountService = accountService;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Collection<Account> accounts = accountService.getAllAccounts();
        receiver.setResult(accounts);
    }
}
