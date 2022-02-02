package by.issoft.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NamedEntityGraph(
        name = "order-info",
        attributeNodes = @NamedAttributeNode(value = "products", subgraph = "product.info"),
        subgraphs = {
                @NamedSubgraph(
                        name = "product.info",
                        attributeNodes = {
                                @NamedAttributeNode("name"),
                                @NamedAttributeNode("rate"),
                                @NamedAttributeNode("price"),
                                @NamedAttributeNode(value = "category", subgraph = "category.info"),
                        }
                ),
                @NamedSubgraph(
                        name = "category.info",
                        attributeNodes = {
                                @NamedAttributeNode("name")
                        }
                )
        }
)
public class OrderInfo extends BaseEntity {
    private String guid;
    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products;

    @Override
    public String toString() {
        return "Order \n" + " orderId = " + guid +
                ",\n products = " + products +
                '\n';
    }
}
