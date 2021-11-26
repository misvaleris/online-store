package by.store;

import by.goods.Category;

import java.util.ArrayList;
import java.util.List;


public class Store {

    private List<Category> categories = new ArrayList<Category>();

    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public String toString() {
        return "\n" + "Online Store" +
                " " + "has the following categories today:" + "\n"
                + "________________________________________________"
                + "\n" + categories;
    }
}
