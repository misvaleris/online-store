package by.issoft.consoleApp.handlers.print;

import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.store.Store;

public class PrintCommand implements AppCommand {
    @Override
    public String execute(Store store) {
        return store.toString();
    }
}
