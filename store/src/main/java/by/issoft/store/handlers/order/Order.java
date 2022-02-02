package by.issoft.store.handlers.order;

import by.issoft.domain.Product;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Order {
    private Long orderId;
    private List<Product> products;

    public Order(Long orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order \n" + " orderId = " + orderId +
                ",\n products = " + products +
                '\n';
    }
}
