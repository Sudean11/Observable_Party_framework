package com.miu.framework.common.Repositories.storage.handler;

import com.miu.framework.common.Repositories.storage.StorageType;

import java.util.List;

public interface StorageHandler<T> {
    void save(T entity, String key);
    void remove(String key);
    T load(String key);
    List<T> getAll();
    StorageType getStorageType();
    void update(T entity, String key);
}

