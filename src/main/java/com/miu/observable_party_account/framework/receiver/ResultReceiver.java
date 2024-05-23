package com.miu.observable_party_account.framework.receiver;

public interface ResultReceiver<T> {
    void setResult(T result);
    T getResult();
}

