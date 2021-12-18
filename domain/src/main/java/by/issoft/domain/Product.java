package by.issoft.domain;

public class Product extends BaseEntity{
    private String name;
    private int rate;
    private double price;

    public Product(long id, String name, int rate, double price) {
        this.id = id;
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
        return "\nProduct " +
                "id = " + id +
                " name = '" + name + '\'' +
                ", rate = " + rate +
                ", price = " + price + "$" + "\n";
    }
}
