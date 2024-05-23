package com.miu.framework.common.Repositories.storage.handler;

import com.miu.framework.common.Repositories.storage.StorageType;

import java.util.HashMap;
import java.util.Map;

public class StorageHandlerRegistry {
    private static final Map<StorageType, StorageHandler<?>> handlers = new HashMap<>();

    public static <T> void registerHandler(StorageType type, StorageHandler<T> handler) {
        handlers.put(type, handler);
    }

    @SuppressWarnings("unchecked")
    public static <T> StorageHandler<T> getHandler(StorageType type) {
        return (StorageHandler<T>) handlers.get(type);
    }
}
