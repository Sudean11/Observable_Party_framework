package com.miu.framework.common.receiver;

public interface ResultReceiver<T> {
    void setResult(T result);
    T getResult();
}

