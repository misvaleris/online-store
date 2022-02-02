package by.issoft.store.handlers.order;

import by.issoft.domain.OrderInfo;
import by.issoft.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final PurchaseService purchaseService;

    public String createOrder(Set<Product> productList) {
        CompletableFuture.runAsync(() -> {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setProducts(productList);
            orderInfo.setGuid(UUID.randomUUID().toString());
            purchaseService.purchaseOrder(orderInfo);
        });
        return "Successfully create order";
    }
}
