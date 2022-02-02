package by.issoft.store.handlers.product;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.domain.Store;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class SortProductsCommand {
    private static final Map<String, Comparator<Product>> AVAILABLE_COMPARATORS
            = new HashMap<String, Comparator<Product>>() {{

        put("name", Comparator.comparing(Product::getName));
        put("price", Comparator.comparing(Product::getPrice));
        put("rate", Comparator.comparing(Product::getRate));
    }};

    private static final String DESC_SORT = "desc";

    public String execute(Store store) {
        Map<String, String> comparatorConfig = getComparatorConfig();
        Comparator<Product> productComparator = buildComparator(comparatorConfig);
        Stream<Product> sortProductsStream = prepareSortProductStream(store, productComparator);
        return finallyModifyStream(sortProductsStream)
                .collect(Collectors.toList())
                .toString();
    }

    protected Stream<Product> finallyModifyStream(Stream<Product> sortProductsStream) {
        return sortProductsStream;
    }

    protected abstract Map<String, String> getComparatorConfig();

    private Comparator<Product> buildComparator(Map<String, String> comparatorConfig) {
        return comparatorConfig.entrySet().stream()
                .map(this::prepareComparator)
                .filter(Objects::nonNull)
                .reduce(Comparator::thenComparing)
                .orElseThrow(NotSupportedOrderClassifierException::new);
    }

    private Comparator<Product> prepareComparator(Map.Entry<String, String> entry) {
        String comparatorName = entry.getKey();
        Comparator<Product> comparator = AVAILABLE_COMPARATORS.getOrDefault(comparatorName, null);

        String sortType = entry.getValue();
        if (DESC_SORT.equals(sortType) && Objects.nonNull(comparator)) {
            comparator = comparator.reversed();
        }
        return comparator;
    }

    private Stream<Product> prepareSortProductStream(Store store, Comparator<Product> comparator) {
        return store.getCategories()
                .stream()
                .map(Category::getProducts)
                .flatMap(List::stream)
                .sorted(comparator);
    }
}
