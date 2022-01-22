package by.issoft.store.handlers.store.print;

import by.issoft.domain.Store;
import org.springframework.stereotype.Service;

@Service
public class PrintStoreCommand {

    public String execute(Store store) {
        return store.toString();
    }
}
