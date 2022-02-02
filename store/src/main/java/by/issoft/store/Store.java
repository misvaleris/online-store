package by.issoft.store;

import by.issoft.domain.Category;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Store {

    @Builder.Default
    private List<Category> categories = new ArrayList<>();

    @Override
    public String toString() {
        return "\n" + "Online Store" +
                " " + "has the following categories today:" + "\n"
                + "________________________________________________"
                + "\n" + categories;
    }
}
