package by.issoft.consoleApp.handlers;

import by.issoft.store.Store;

public class EmptyHandler implements MyHandler{
    @Override
    public void execute(Store store) {
        System.out.println("Unknown command");
    }
}
