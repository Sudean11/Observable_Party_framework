package com.miu.framework.bank.reveiver;

import com.miu.framework.common.receiver.ResultReceiver;

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
