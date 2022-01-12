package by.issoft.store.handlers.order;

import by.issoft.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Service
public class CreateOrderService {
    private final PurchaseService purchaseService;

    public String createOrder(List<Product> productList) {
        CompletableFuture.runAsync(() -> {
            Order order = new Order(ThreadLocalRandom.current().nextLong(1, 31), productList);
            purchaseService.purchaseOrder(order);
        });
        return "Successfully create order";
    }
}
