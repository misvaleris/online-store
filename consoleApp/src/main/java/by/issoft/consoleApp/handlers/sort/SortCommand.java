package by.issoft.consoleApp.handlers.sort;

import by.issoft.consoleApp.StoreApp;
import by.issoft.consoleApp.handlers.AppCommand;
import by.issoft.domain.Product;
import by.issoft.store.Store;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class SortCommand implements AppCommand {
    private final static XmlMapper XML_MAPPER = new XmlMapper();

    @Override
    public void execute(Store store) {
        Map<String, String> productSortConfig = getProductSortConfig();
        Comparator<Product> resultComparator = getProductComparator(productSortConfig);

        prepareSortProductList(store, resultComparator)
                .forEach(System.out::println);
    }

    private Comparator<Product> getProductComparator(Map<String, String> productSortConfig) {

        boolean sortProductNameAsc = "asc".equals(productSortConfig.get("name"));
        boolean sortProductPriceAsc = "asc".equals(productSortConfig.get("price"));
        boolean sortProductRateAsc = "asc".equals(productSortConfig.get("rate"));

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

    private Map<String, String> getProductSortConfig() {
        String xml = null;
        try {
            File file = getFileFromResource();
            xml = inputStreamToString(new FileInputStream(file));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Map<String, String> value;
        try {
            value = XML_MAPPER.readValue(xml, Map.class);
        } catch (JsonProcessingException e) {
            value = Collections.emptyMap();
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
