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

    public String getName() {
        return this.name;
    }

    public int getRate() {
        return this.rate;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product " +
                "name = '" + name + '\'' +
                ", rate = " + rate +
                ", price = " + price + "$" + "\n";
    }
}
