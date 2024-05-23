package com.miu.framework.common.Repositories.storage;

import com.miu.framework.common.Repositories.storage.handler.*;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataAccessFacade {
    static {
        ensureDirectoryExists(getOutputDir());
        ensureDirectoryExists(getOutputDirMac());
        StorageHandlerRegistry.registerHandler(StorageType.ACCOUNTS, new AccountStorageHandler());
        StorageHandlerRegistry.registerHandler(StorageType.CREDIT_CARDS, new CreditCardStorageHandler());
        StorageHandlerRegistry.registerHandler(StorageType.PARTIES, new PartyStorageHandler());
        StorageHandlerRegistry.registerHandler(StorageType.CREDIT_PARTIES, new CreditPartyStorageHandler());
    }

    private static String getOutputDir() {
        String userDir = System.getProperty("user.dir");
        if (userDir == null) {
            throw new IllegalStateException("System property 'user.dir' is not set.");
        }
        return userDir + "/src/main/resources/storage";
    }

    private static String getOutputDirMac() {
        String userDir = System.getProperty("user.dir");
        if (userDir == null) {
            throw new IllegalStateException("System property 'user.dir' is not set.");
        }
        return userDir + "/src/main/resources/storage";
    }

    public <T> void save(T entity, String key, StorageType type) {
        StorageHandler<T> handler = StorageHandlerRegistry.getHandler(type);
        System.out.println("Handler:: "+handler.toString());
        handler.save(entity, key);
    }

    public <T> void remove(String key, StorageType type) {
        StorageHandler<T> handler = StorageHandlerRegistry.getHandler(type);
        handler.remove(key);
    }

    public <T> T load(String key, StorageType type) {
        StorageHandler<T> handler = StorageHandlerRegistry.getHandler(type);
        return handler.load(key);
    }

    public <T> List<T> getAll(StorageType type) {
        StorageHandler<T> handler = StorageHandlerRegistry.getHandler(type);
        return handler.getAll();
    }

    public <T> void update(T entity, String key, StorageType type) {
        StorageHandler<T> handler = StorageHandlerRegistry.getHandler(type);
        handler.update(entity, key);
    }

    public static void saveToStorage(StorageType type, Object ob) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(getPath(type)))) {
            out.writeObject(ob);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readFromStorage(StorageType type) {
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(String.valueOf(getPath(type)))))) {
            // Read the serialized object from the input stream
            return inputStream.readObject();
        } catch (EOFException eofException) {
            // Handle EOFException if end of file is reached unexpectedly
            System.err.println("End of file reached unexpectedly while reading from storage.");
            eofException.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            // Handle other IO and class not found exceptions
            System.err.println("Error reading from storage.");
            e.printStackTrace();
        }
        return null;
    }

    private static Path getPath(StorageType type) {
        String osName = System.getProperty("os.name");
        boolean isMac = osName.startsWith("Mac");
        String dir = isMac ? getOutputDirMac() : getOutputDir();
        Path path = FileSystems.getDefault().getPath(dir, type.toString());
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    private static void ensureDirectoryExists(String dirPath) {
        Path path = FileSystems.getDefault().getPath(dirPath);
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
