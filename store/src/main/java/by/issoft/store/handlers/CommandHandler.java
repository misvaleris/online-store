package by.issoft.store.handlers;

import by.issoft.store.handlers.order.CreateOrderCommand;
import by.issoft.store.handlers.store.print.PrintStoreCommand;
import by.issoft.store.handlers.quit.QuitCommand;
import by.issoft.store.handlers.product.sort.GetSortByPriceRateNameProductCommand;
import by.issoft.store.handlers.product.top.GetTop5ByPriceProductCommand;
import by.issoft.store.Store;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private static CommandHandler instance;
    private final static Map<String, AppCommand> COMMAND_LIST = new HashMap<String, AppCommand>(){{
       put("", new EmptyCommand());
       put("sort", new GetSortByPriceRateNameProductCommand());
       put("top", new GetTop5ByPriceProductCommand());
       put("print", new PrintStoreCommand());
       put("quit", new QuitCommand());
       put("create-order", new CreateOrderCommand());
    }};

    public static synchronized CommandHandler getInstance() {
        if (instance == null) {
            instance = new CommandHandler();
        }
        return instance;
    }

    public String handleCommand(String commandName, Store store){
        AppCommand command = COMMAND_LIST.getOrDefault(commandName, COMMAND_LIST.get(""));
        return command.execute(store);
    }
}