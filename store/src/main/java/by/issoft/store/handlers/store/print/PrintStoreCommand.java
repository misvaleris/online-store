package by.issoft.store.handlers.store.print;

import by.issoft.store.handlers.AppCommand;
import by.issoft.store.Store;

public class PrintStoreCommand implements AppCommand {
    @Override
    public String execute(Store store) {
        return store.toString();
    }
}
