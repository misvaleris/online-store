package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import com.github.javafaker.Faker;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class RandomStorePopulator {
    private static RandomStorePopulator instance;
    private static final Faker FAKER = new Faker();

    private RandomStorePopulator() {

    }

    public static synchronized RandomStorePopulator getInstance() {
        if (instance == null) {
            instance = new RandomStorePopulator();
        }
        return instance;
    }

    public void populateCategoryWithProducts(Category category) {

        int numberOfProducts = FAKER.number().numberBetween(2, 10);

        for (int i = 0; i < numberOfProducts; i++) {
            Product newProduct = new Product(
                    FAKER.name().title(),
                    FAKER.number().numberBetween(1, 10),
                    FAKER.number().randomDouble(2, 1, 10)
            );
            category.addProduct(newProduct);
        }
    }

    public List<Category> generateCategories() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        List<Category> categories = new ArrayList<Category>();

        Reflections reflections = new Reflections("by.issoft.domain");
        Set<Class<?>> subTypes =
                reflections.get(SubTypes.of(Category.class).asClass());

        for (Class<?> clazz : subTypes) {

            Constructor<?> constructor = clazz.getConstructor();
            Category category = (Category) constructor.newInstance();

            populateCategoryWithProducts(category);
            categories.add(category);
        }

        return categories;
    }
}
