package by.issoft.consoleApp;

import by.issoft.consoleApp.handlers.CommandHandler;
import by.issoft.consoleApp.handlers.quit.QuitProgramException;
import by.issoft.domain.Category;
import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        List<Category> categories = randomStorePopulator.generateCategories();
        Store store = new Store();
        store.addCategories(categories);

        CommandHandler commandHandler = new CommandHandler();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Put your command here:");
                String command = scanner.nextLine();
                System.out.printf("Your command: %s \n", command);

                String result = commandHandler.handleCommand(command, store);
                System.out.println(result);
            }
        } catch (QuitProgramException e) {
            System.out.println(e.getMessage());
        }
    }
}
