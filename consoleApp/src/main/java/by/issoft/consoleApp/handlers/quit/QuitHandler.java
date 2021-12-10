package by.issoft.consoleApp.handlers.quit;

import by.issoft.consoleApp.handlers.MyHandler;
import by.issoft.store.Store;

public class QuitHandler implements MyHandler {
    @Override
    public void execute(Store store) {
        throw new QuitProgramException();
    }
}
