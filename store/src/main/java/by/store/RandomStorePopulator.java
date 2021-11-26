package by.store;

import by.goods.Category;
import by.goods.Product;
import com.github.javafaker.Faker;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class RandomStorePopulator {

    Faker faker = new Faker();

    public void populateCategoryWithProducts(Category category) {

        int numberOfProducts = faker.number().numberBetween(2, 10);

        for (int i = 0; i < numberOfProducts; i++) {
            Product newProduct = new Product(
                    faker.name().title(),
                    faker.number().numberBetween(1, 10),
                    faker.number().randomDouble(2, 1, 10)
            );
            category.addProduct(newProduct);
        }
    }

    public Store generateStore() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Store store = new Store();

        Reflections reflections = new Reflections("by.goods");
        Set<Class<?>> subTypes =
                reflections.get(SubTypes.of(Category.class).asClass());

        for (Class<?> clazz : subTypes) {

            Constructor<?> constructor = clazz.getConstructor(String.class);
            String categoryName = clazz.getSimpleName();
            Category category = (Category) constructor.newInstance(categoryName);

            populateCategoryWithProducts(category);
            store.addCategory(category);
        }

        return store;
    }
}
