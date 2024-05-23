package com.miu.observable_party_account.framework.command;

import com.miu.observable_party_account.framework.entity.Account;
import com.miu.observable_party_account.framework.receiver.ResultReceiver;
import com.miu.observable_party_account.framework.service.AccountService;

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
