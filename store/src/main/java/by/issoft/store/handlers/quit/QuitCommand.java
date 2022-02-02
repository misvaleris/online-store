package by.issoft.store.handlers.quit;

import by.issoft.domain.Store;
import org.springframework.stereotype.Service;

@Service
public class QuitCommand {

    public String execute(Store store) {
        throw new QuitProgramException();
    }
}
