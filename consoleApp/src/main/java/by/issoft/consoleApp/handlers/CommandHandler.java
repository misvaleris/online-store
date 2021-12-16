package by.issoft.consoleApp.handlers;

import by.issoft.consoleApp.handlers.print.PrintCommand;
import by.issoft.consoleApp.handlers.quit.QuitCommand;
import by.issoft.consoleApp.handlers.sort.SortCommand;
import by.issoft.consoleApp.handlers.top.TopCommand;
import by.issoft.store.Store;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final static Map<String, AppCommand> COMMAND_LIST = new HashMap<String, AppCommand>(){{
       put("", new EmptyCommand());
       put("sort", new SortCommand());
       put("top", new TopCommand());
       put("print", new PrintCommand());
       put("quit", new QuitCommand());
    }};

    public void handleCommand(String commandName, Store store){
        AppCommand command = COMMAND_LIST.getOrDefault(commandName, COMMAND_LIST.get(""));
        command.execute(store);
    }
}
