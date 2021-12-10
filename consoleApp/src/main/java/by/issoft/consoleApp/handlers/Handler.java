package by.issoft.consoleApp.handlers;

import by.issoft.consoleApp.handlers.print.PrintHandler;
import by.issoft.consoleApp.handlers.quit.QuitHandler;
import by.issoft.consoleApp.handlers.sort.SortHandler;
import by.issoft.consoleApp.handlers.top.TopHandler;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Handler {
    EMPTY("", new EmptyHandler()),
    SORT("sort", new SortHandler()),
    TOP("top", new TopHandler()),
    PRINT("print", new PrintHandler()),
    QUIT("quit", new QuitHandler());

    private final String name;
    private final MyHandler handler;

    private static final Map<String, Handler> commands = Arrays.stream(Handler.values())
            .collect(Collectors.toMap(Handler::getName, x -> x));

    Handler(String name, MyHandler handler) {
        this.name = name;
        this.handler = handler;
    }

    public String getName() {
        return name;
    }

    public MyHandler getHandler() {
        return handler;
    }

    public static Handler getCommand(String commandName) {
        return commands.getOrDefault(commandName, EMPTY);
    }
}
