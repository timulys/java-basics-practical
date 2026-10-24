package study.javaorder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductCatalog {
    private final Map<String, Product> products = new HashMap<>();
    private final Set<Product> registeredProducts = new HashSet<>();

    public boolean register(Product product) {
        if (!registeredProducts.add(product)) {
            return false;
        }
        products.put(product.getCode(), product);
        return true;
    }

    public Product find(String productCode) {
        return products.get(productCode);
    }

    public int size() {
        return products.size();
    }
}
