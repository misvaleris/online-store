package by.issoft.consoleApp.handlers.top;

import by.issoft.consoleApp.handlers.SortProductsCommand;
import by.issoft.domain.Product;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

public class TopCommand extends SortProductsCommand {

    @Override
    protected Map<String, String> getComparatorConfig() {
        return Collections.singletonMap("price", "desc");
    }

    @Override
    protected Stream<Product> finallyModifyStream(Stream<Product> sortProductsStream) {
        return sortProductsStream.limit(5);
    }
}
