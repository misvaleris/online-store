package by.issoft.consoleApp.handlers.order;

import by.issoft.domain.Product;

import java.util.List;

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
