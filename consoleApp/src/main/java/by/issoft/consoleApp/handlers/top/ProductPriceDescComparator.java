package by.issoft.consoleApp.handlers.top;

import by.issoft.domain.Product;

import java.util.Comparator;

public class ProductPriceDescComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        double price1 = product1.getPrice();
        double price2 = product2.getPrice();
        return Double.compare(price2, price1);
    }
}
