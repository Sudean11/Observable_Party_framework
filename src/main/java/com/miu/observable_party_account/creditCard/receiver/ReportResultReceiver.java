package com.miu.observable_party_account.creditCard.receiver;

import com.miu.observable_party_account.framework.receiver.ResultReceiver;

public class ReportResultReceiver implements ResultReceiver<String> {
    private String report;
    @Override
    public void setResult(String result) {
        report = result;
    }

    @Override
    public String getResult() {
        return report;
    }
}
