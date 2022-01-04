package by.issoft.domain;
import java.util.ArrayList;
import java.util.List;

public abstract class Category extends BaseEntity {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts(){
        return this.products;
    }

    @Override
    public String toString() {
        return "\n" +"**** " + name + " ****" + "\n" +
                "This category include products:"
                + "\n" + "\n" + products + "\n" + "\n";
    }
}
