package by.issoft.store.handlers.order;

import by.issoft.domain.Product;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CreateOrderService {
    private static CreateOrderService INSTANCE;
    private static final PurchaseService PURCHASE_SERVICE = PurchaseService.getInstance();

    private CreateOrderService() {
    }

    public synchronized static CreateOrderService getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new CreateOrderService();
        }
        return INSTANCE;
    }

    public String createOrder(List<Product> productList) {
        CompletableFuture.runAsync(() -> {
            Order order = new Order(ThreadLocalRandom.current().nextLong(1, 31), productList);
//            System.out.println("Created order " + order);
            PURCHASE_SERVICE.purchaseOrder(order);
        });
        return "Successfully create order";
    }
}
