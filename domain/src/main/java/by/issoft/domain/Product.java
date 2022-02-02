package by.issoft.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {
    private String name;
    private int rate;
    private double price;
    @ManyToOne
    private Category category;

    @Override
    public String toString() {
        return "\nProduct " +
                "id = " + id +
                " name = '" + name + '\'' +
                ", rate = " + rate +
                ", price = " + price + "$" + "\n";
    }
}
