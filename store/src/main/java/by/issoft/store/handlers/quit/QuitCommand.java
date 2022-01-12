package by.issoft.store.handlers.quit;

import by.issoft.store.handlers.AppCommand;
import by.issoft.store.Store;
import org.springframework.stereotype.Service;

@Service
public class QuitCommand implements AppCommand {
    @Override
    public String execute(Store store) {
        throw new QuitProgramException();
    }
}
