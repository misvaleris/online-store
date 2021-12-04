package by.issoft.domain;

public class Product {
    private String name;
    private int rate;
    private double price;

    public Product(String name, int rate, double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product " +
                "name = '" + name + '\'' +
                ", rate = " + rate +
                ", price = " + price + "$" + "\n";
    }
}
