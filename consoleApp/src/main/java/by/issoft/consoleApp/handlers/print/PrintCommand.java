package by.issoft.consoleApp.handlers.print;

import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.store.Store;

public class PrintCommand implements AppCommand {
    @Override
    public void execute(Store store) {
        System.out.println(store);
    }
}
