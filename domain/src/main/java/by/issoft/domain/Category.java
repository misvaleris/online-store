package by.issoft.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NamedEntityGraph(name = "all-products", attributeNodes = @NamedAttributeNode("products"))
public class Category extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "\n" + "**** " + name + " ****" + "\n" +
                "This category include products:"
                + "\n" + "\n" + products + "\n" + "\n";
    }
}
