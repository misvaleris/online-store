package by.issoft.store.handlers.quit;

import by.issoft.store.handlers.AppCommand;
import by.issoft.store.Store;

public class QuitCommand implements AppCommand {
    @Override
    public String execute(Store store) {
        throw new QuitProgramException();
    }
}
