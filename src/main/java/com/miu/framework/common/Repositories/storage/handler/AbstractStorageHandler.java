package com.miu.framework.common.Repositories.storage.handler;

import com.miu.framework.common.Repositories.storage.DataAccessFacade;
import com.miu.framework.common.Repositories.storage.StorageType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorageHandler<T> implements StorageHandler<T> {
    private Map<String, T> storageMap = new HashMap<>();

    @Override
    public void save(T entity, String key) {
        storageMap.put(key, entity);
        persist();
    }

    @Override
    public void remove(String key) {
        storageMap.remove(key);
        persist();
    }

    @Override
    public T load(String key) {
        return storageMap.get(key);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public void update(T entity, String key) {
        storageMap.put(key, entity);
        persist();
    }

    public abstract StorageType getStorageType();

    @SuppressWarnings("unchecked")
    private void loadStorage() {
        Object data = DataAccessFacade.readFromStorage(getStorageType());
        if (data != null) {
            storageMap = (HashMap<String, T>) data;
        }
    }

    private void persist() {
        DataAccessFacade.saveToStorage(getStorageType(), storageMap);
    }

    public AbstractStorageHandler() {
        loadStorage();
    }
}
