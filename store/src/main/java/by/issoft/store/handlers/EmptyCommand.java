package by.issoft.store.handlers;

import by.issoft.store.Store;

public class EmptyCommand implements AppCommand {
    private static final String MESSAGE = "Unknown command";

    @Override
    public String execute(Store store) {
        return MESSAGE;
    }
}
