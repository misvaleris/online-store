package by.issoft.store.handlers.product.sort;

import by.issoft.store.handlers.product.SortProductsCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

@Service
public class GetSortByPriceRateNameProductCommand extends SortProductsCommand {
    private final static XmlMapper XML_MAPPER = new XmlMapper();

    @Override
    protected Map<String, String> getComparatorConfig() {
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

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("sort.xml");
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + "sort.xml");
        } else {
            return new File(resource.toURI());
        }
    }
}
