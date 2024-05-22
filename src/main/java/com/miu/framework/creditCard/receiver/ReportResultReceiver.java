package com.miu.framework.creditCard.receiver;

import com.miu.framework.common.receiver.ResultReceiver;

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
