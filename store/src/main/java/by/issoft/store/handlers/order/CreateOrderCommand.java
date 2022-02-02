package by.issoft.store.handlers.order;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.Store;
import by.issoft.store.handlers.AppCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateOrderCommand implements AppCommand {
    private final CreateOrderService createOrderService;
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String execute(Store store) {
        Map<Long, Product> availableProducts = buildAvailableProductMap(store);
        try {
            log.info("Available product list:");
            availableProducts.values()
                    .forEach(System.out::println);

            log.info("Select product to order. Print product id in row as 1,2,3: ");
            String productIds = BUFFERED_READER.readLine();
            log.info("Products to order: {} \n", productIds);

            List<Product> productsForOrder = Stream.of(productIds.split(","))
                    .map(Long::parseLong)
                    .map(productId -> availableProducts.getOrDefault(productId, null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            return createOrderService.createOrder(productsForOrder);
        } catch (Exception e) {
            log.info(e.getMessage());
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
