package by.issoft.consoleApp.handlers;

import by.issoft.store.Store;

public class CommandHandler {

    public void handleCommand(String command, Store store){
        Handler handler = Handler.getCommand(command);
        handler.getHandler().execute(store);
    }
}
