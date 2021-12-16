package by.issoft.consoleApp.handlers;

import by.issoft.consoleApp.handlers.print.PrintCommand;
import by.issoft.consoleApp.handlers.quit.QuitCommand;
import by.issoft.consoleApp.handlers.sort.SortCommand;
import by.issoft.consoleApp.handlers.top.TopCommand;
import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private static CommandHandler instance;
    private final static Map<String, AppCommand> COMMAND_LIST = new HashMap<String, AppCommand>(){{
       put("", new EmptyCommand());
       put("sort", new SortCommand());
       put("top", new TopCommand());
       put("print", new PrintCommand());
       put("quit", new QuitCommand());
    }};

    public static synchronized CommandHandler getInstance() {
        if (instance == null) {
            instance = new CommandHandler();
        }
        return instance;
    }

    public void handleCommand(String commandName, Store store){
        AppCommand command = COMMAND_LIST.getOrDefault(commandName, COMMAND_LIST.get(""));
        command.execute(store);
    }
}
