package by.issoft.consoleApp;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {

        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        List<Category> categories = randomStorePopulator.generateCategories();
        Store store = new Store();
        store.addCategories(categories);

        List<Category> categoryCopies = new ArrayList<>(categories);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, our dear user, please enter one of the command from list to continue: \n sort \n top \n print \n quit ");

        while (true) {
            System.out.print("Put your answer here:");
            String userAnswer = scanner.nextLine();
            System.out.printf("Your answer: %s \n", userAnswer);

            if ("print".equals(userAnswer)) {
                System.out.println(store);
            } else if ("sort".equals(userAnswer)) {
                //read xml

                boolean sortProductNameAsc = true;
                boolean sortProductPriceAsc = true;
                boolean sortProductRateAsc = false;
                //googled how compare with several properties
                Comparator<Product> nameComparator = Comparator.comparing(Product::getName);
                if (!sortProductNameAsc) {
                    nameComparator.reversed();
                }
                Comparator<Product> priceComparator = Comparator.comparing(Product::getPrice);
                if (!sortProductPriceAsc) {
                    priceComparator.reversed();
                }
                Comparator<Product> rateComparator = Comparator.comparing(Product::getRate);
                if (!sortProductRateAsc) {
                    rateComparator.reversed();
                }

                Comparator<Product> resultComparator = nameComparator
                        .thenComparing(priceComparator)
                        .thenComparing(rateComparator);

                //get products from category list
                categoryCopies
                        .stream()
                        .map(Category::getProducts)
                        .flatMap(List::stream)
                        .sorted(resultComparator)
                        .forEach(System.out::println);

            } else if ("top".equals(userAnswer)) {
                categoryCopies
                        .stream()
                        .map(Category::getProducts)
                        .flatMap(List::stream)
                        .sorted(new ProductPriceDescComparator())
                        .limit(5)
                        .forEach(System.out::println);
            } else if ("quit".equals(userAnswer)) {
                scanner.close();
                break;
            }
        }
    }
}
