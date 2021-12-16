package by.issoft.consoleApp.handlers;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public interface AppCommand {
    /**
     * Logic for command execution
     *
     * @param store info for command execution
     */
    void execute(Store store);

    /**
     * Return stream of store products
     *
     * @param store store to use
     * @return stream of products
     */
    default Stream<Product> prepareSortProductList(Store store, Comparator<Product> comparator) {
        return store.getCategories()
                .stream()
                .map(Category::getProducts)
                .flatMap(List::stream)
                .sorted(comparator);
    }
}
