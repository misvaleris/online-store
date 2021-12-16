package by.issoft.consoleApp.handlers;

import by.issoft.store.Store;

public class EmptyCommand implements AppCommand {
    @Override
    public void execute(Store store) {
        System.out.println("Unknown command");
    }
}
