package by.issoft.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {
    private String name;
    private int rate;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<OrderInfo> orderInfos;

    @Override
    public String toString() {
        return "\nProduct " +
                "id = " + id +
                " name = '" + name + '\'' +
                ", rate = " + rate +
                ", price = " + price + "$" + "\n";
    }
}
