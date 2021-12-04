package by.issoft.consoleApp;

import by.issoft.domain.Category;
import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class StoreApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        List<Category> categories = randomStorePopulator.generateCategories();
        Store store = new Store();
        store.addCategories(categories);
        System.out.println(store);
    }
}
