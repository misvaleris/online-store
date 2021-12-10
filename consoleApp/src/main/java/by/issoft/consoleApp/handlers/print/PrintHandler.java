package by.issoft.consoleApp.handlers.print;

import by.issoft.consoleApp.handlers.MyHandler;
import by.issoft.store.Store;

public class PrintHandler implements MyHandler {
    @Override
    public void execute(Store store) {
        System.out.println(store);
    }
}
