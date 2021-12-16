package by.issoft.consoleApp.handlers.quit;

import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.store.Store;

public class QuitCommand implements AppCommand {
    @Override
    public void execute(Store store) {
        throw new QuitProgramException();
    }
}
