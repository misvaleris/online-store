package by.issoft.consoleApp.handlers.order;

import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.Store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateOrderCommand implements AppCommand {
    private static final CreateOrderService CREATE_ORDER_SERVICE = CreateOrderService.getInstance();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String execute(Store store) {
        Map<Long, Product> availableProducts = buildAvailableProductMap(store);
        try {
            System.out.println("Available product list:");
            availableProducts.values()
                    .forEach(System.out::println);

            System.out.print("Select product to order. Print product id in row as 1,2,3: ");
            String productIds = BUFFERED_READER.readLine();
            System.out.printf("Products to order: %s \n", productIds);

            List<Product> productsForOrder = Stream.of(productIds.split(","))
                    .map(Long::parseLong)
                    .map(productId -> availableProducts.getOrDefault(productId, null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            return CREATE_ORDER_SERVICE.createOrder(productsForOrder);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "ERROR on creating order";
        }
    }

    private Map<Long, Product> buildAvailableProductMap(Store store) {
        return store.getCategories()
                .stream()
                .map(Category::getProducts)
                .flatMap(List::stream)
                .collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
