package by.issoft.consoleApp.handlers;

import by.issoft.store.Store;

public interface MyHandler {
    /**
     * Logic for command execution
     * @param store info for command execution
     */
    void execute(Store store);
}
