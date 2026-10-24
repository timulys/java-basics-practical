package study.javaorder;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private final Map<String, Product> products = new HashMap<>();

    public void register(Product product) {
        products.put(product.getCode(), product);
    }

    public Product find(String productCode) {
        return products.get(productCode);
    }

    public int size() {
        return products.size();
    }
}
