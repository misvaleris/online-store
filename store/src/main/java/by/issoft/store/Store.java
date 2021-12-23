package by.issoft.store;

import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;


public class Store {

    private Store() {

    }

    private List<Category> categories = new ArrayList<Category>();

    public void addCategories(List<Category> categories) {
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

    public static Builder builder() {
        return new Store().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder categories(List<Category> categories) {
            Store.this.categories = categories;
            return this;
        }

        public Store build() {
            return Store.this;
        }
    }
}
