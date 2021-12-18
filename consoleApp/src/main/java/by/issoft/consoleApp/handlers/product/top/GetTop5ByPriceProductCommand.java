package by.issoft.consoleApp.handlers.product.top;

import by.issoft.consoleApp.handlers.product.SortProductsCommand;
import by.issoft.domain.Product;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

public class GetTop5ByPriceProductCommand extends SortProductsCommand {

    @Override
    protected Map<String, String> getComparatorConfig() {
        return Collections.singletonMap("price", "desc");
    }

    @Override
    protected Stream<Product> finallyModifyStream(Stream<Product> sortProductsStream) {
        return sortProductsStream.limit(5);
    }
}
