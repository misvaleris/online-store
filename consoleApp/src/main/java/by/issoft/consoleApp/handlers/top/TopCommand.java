package by.issoft.consoleApp.handlers.top;

import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.store.Store;

public class TopCommand implements AppCommand {
    @Override
    public void execute(Store store) {
        prepareSortProductList(store, new ProductPriceDescComparator())
                .limit(5)
                .forEach(System.out::println);
    }
}
