package by.issoft.consoleApp.handlers;

import by.issoft.store.Store;

public interface AppCommand {
    /**
     * Logic for command execution
     *
     * @param store info for command execution
     * @return result to show
     */
    String execute(Store store);
}
