package by.issoft.store.handlers;

import by.issoft.store.Store;
import by.issoft.store.handlers.order.CreateOrderCommand;
import by.issoft.store.handlers.product.sort.GetSortByPriceRateNameProductCommand;
import by.issoft.store.handlers.product.top.GetTop5ByPriceProductCommand;
import by.issoft.store.handlers.quit.QuitCommand;
import by.issoft.store.handlers.store.print.PrintStoreCommand;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommandHandler {

    private final Map<String, AppCommand> commandList = new HashMap<>();

    public CommandHandler(EmptyCommand emptyCommand,
                          GetSortByPriceRateNameProductCommand getSortByPriceRateNameProductCommand,
                          GetTop5ByPriceProductCommand getTop5ByPriceProductCommand,
                          PrintStoreCommand printStoreCommand,
                          QuitCommand quitCommand, CreateOrderCommand createOrderCommand) {

        commandList.put("", emptyCommand);
        commandList.put("sort", getSortByPriceRateNameProductCommand);
        commandList.put("top", getTop5ByPriceProductCommand);
        commandList.put("print", printStoreCommand);
        commandList.put("quit", quitCommand);
        commandList.put("create-order", createOrderCommand);
    }

    public String handleCommand(String commandName, Store store){
        AppCommand command = commandList.getOrDefault(commandName, commandList.get(""));
        return command.execute(store);
    }
}
