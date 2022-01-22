package by.issoft.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NamedEntityGraph(
        name = "store-info",
        attributeNodes = @NamedAttributeNode(value = "categories", subgraph = "category"),
        subgraphs = {
                @NamedSubgraph(
                        name = "category",
                        attributeNodes = {
                                @NamedAttributeNode("products")
                        }
                )
        }
)
public class Store extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "store")
    private List<Category> categories;

    @Override
    public String toString() {
        return "\n" + "Online Store" +
                " " + "has the following categories today:" + "\n"
                + "________________________________________________"
                + "\n" + categories;
    }
}
