package by.issoft.consoleApp;

import by.issoft.domain.Category;
import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;
import by.issoft.store.handlers.CommandHandler;
import by.issoft.store.handlers.quit.QuitProgramException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class StoreApp {

    private static final RandomStorePopulator POPULATOR = RandomStorePopulator.getInstance();
    private static final CommandHandler COMMAND_HANDLER = CommandHandler.getInstance();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<Category> categories = POPULATOR.generateCategories();
        Store store = Store.builder()
                .categories(categories)
                .build();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Try to put your command here:");
                if (scanner.hasNext()) {
                    String command = scanner.nextLine();
                    System.out.printf("Your command: %s \n", command);

                    String result = COMMAND_HANDLER.handleCommand(command, store);
                    System.out.println(result);
                }
            }
        } catch (QuitProgramException e) {
            System.out.println(e.getMessage());
        }
    }
}
