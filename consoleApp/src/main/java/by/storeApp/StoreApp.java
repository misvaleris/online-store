package by.storeApp;

import by.store.RandomStorePopulator;
import by.store.Store;

import java.lang.reflect.InvocationTargetException;

public class StoreApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        Store store = randomStorePopulator.generateStore();
        System.out.println(store);
    }
}
