package by.issoft.store;

import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;


public class Store {

    private List<Category> categories = new ArrayList<Category>();

    public void addCategories(List <Category> categories) {
        this.categories.addAll(categories);
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "\n" + "Online Store" +
                " " + "has the following categories today:" + "\n"
                + "________________________________________________"
                + "\n" + categories;
    }
}
