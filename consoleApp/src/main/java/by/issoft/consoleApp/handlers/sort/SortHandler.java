package by.issoft.consoleApp.handlers.sort;

import by.issoft.consoleApp.StoreApp;
import by.issoft.consoleApp.handlers.MyHandler;
import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.store.Store;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;

public class SortHandler implements MyHandler {
    @Override
    public void execute(Store store) {
        Comparator<Product> resultComparator = getProductComparator();

        store.getCategories()
                .stream()
                .map(Category::getProducts)
                .flatMap(List::stream)
                .sorted(resultComparator)
                .forEach(System.out::println);
    }

    private Comparator<Product> getProductComparator() {
        ProductSortConfig value = getProductSortConfig();

        boolean sortProductNameAsc = "asc".equals(value.getNameSortConfig());
        boolean sortProductPriceAsc = "asc".equals(value.getPriceSortConfig());
        boolean sortProductRateAsc = "asc".equals(value.getRateSortConfig());

        Comparator<Product> nameComparator = Comparator.comparing(Product::getName);
        if (!sortProductNameAsc) {
            nameComparator = nameComparator.reversed();
        }
        Comparator<Product> priceComparator = Comparator.comparing(Product::getPrice);
        if (!sortProductPriceAsc) {
            priceComparator = priceComparator.reversed();
        }
        Comparator<Product> rateComparator = Comparator.comparing(Product::getRate);
        if (!sortProductRateAsc) {
            rateComparator.reversed();
        }

        return nameComparator
                .thenComparing(priceComparator)
                .thenComparing(rateComparator);
    }

    private ProductSortConfig getProductSortConfig() {
        String xml = null;
        try {
            File file = getFileFromResource();
            xml = inputStreamToString(new FileInputStream(file));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        XmlMapper xmlMapper = new XmlMapper();
        ProductSortConfig value = null;
        try {
            value = xmlMapper.readValue(xml, ProductSortConfig.class);
        } catch (JsonProcessingException e) {
            value = new ProductSortConfig();
        }
        return value;
    }


    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    private File getFileFromResource() throws URISyntaxException {

        ClassLoader classLoader = StoreApp.class.getClassLoader();
        URL resource = classLoader.getResource("sort.xml");
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + "sort.xml");
        } else {
            return new File(resource.toURI());
        }
    }
}
