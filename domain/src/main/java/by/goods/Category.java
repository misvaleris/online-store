package by.goods;
import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    private List<Product> products = new ArrayList<Product>();

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "\n" +"**** " + name + " ****" + "\n" +
                "This category include products:"
                + "\n" + "\n" + products + "\n" + "\n";
    }
}
