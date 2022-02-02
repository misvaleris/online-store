package by.issoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NamedEntityGraph(name = "all-products", attributeNodes = @NamedAttributeNode("products"))
public class Category extends BaseEntity {
    private String name;
    @JsonIgnore
    @ManyToOne
    private Store store;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "\n" + "**** " + name + " ****" + "\n" +
                "This category include products:"
                + "\n" + "\n" + products + "\n" + "\n";
    }
}
