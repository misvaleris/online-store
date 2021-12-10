package by.issoft.consoleApp.handlers.top;

import by.issoft.consoleApp.handlers.MyHandler;
import by.issoft.domain.Category;
import by.issoft.store.Store;

import java.util.List;

public class TopHandler implements MyHandler {
    @Override
    public void execute(Store store) {
        store.getCategories()
                .stream()
                .map(Category::getProducts)
                .flatMap(List::stream)
                .sorted(new ProductPriceDescComparator())
                .limit(5)
                .forEach(System.out::println);
    }
}
