package by.issoft.consoleApp.handlers.store.print;

import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.store.Store;

public class PrintStoreCommand implements AppCommand {
    @Override
    public String execute(Store store) {
        return store.toString();
    }
}
