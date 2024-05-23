package com.miu.observable_party_account.bank.reveiver;

import com.miu.observable_party_account.framework.receiver.ResultReceiver;

public class TransactionHistroyReceiver implements ResultReceiver<String> {
    private String transactionHistory;

    @Override
    public void setResult(String result) {
        transactionHistory=result;
    }

    @Override
    public String getResult() {
        return transactionHistory;
    }
}
