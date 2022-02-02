package by.issoft.store.handlers.store.print;

import by.issoft.store.handlers.AppCommand;
import by.issoft.store.Store;
import org.springframework.stereotype.Service;

@Service
public class PrintStoreCommand implements AppCommand {
    @Override
    public String execute(Store store) {
        return store.toString();
    }
}
