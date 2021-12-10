package by.issoft.consoleApp.handlers.sort;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "sort")
public class ProductSortConfig {
    @JacksonXmlProperty(localName = "name")
    private String nameSortConfig = "asc";
    @JacksonXmlProperty(localName = "price")
    private String priceSortConfig = "asc";
    @JacksonXmlProperty(localName = "rate")
    private String rateSortConfig = "asc";

    public String getNameSortConfig() {
        return nameSortConfig;
    }

    public void setNameSortConfig(String nameSortConfig) {
        this.nameSortConfig = nameSortConfig;
    }

    public String getPriceSortConfig() {
        return priceSortConfig;
    }

    public void setPriceSortConfig(String priceSortConfig) {
        this.priceSortConfig = priceSortConfig;
    }

    public String getRateSortConfig() {
        return rateSortConfig;
    }

    public void setRateSortConfig(String rateSortConfig) {
        this.rateSortConfig = rateSortConfig;
    }
}
