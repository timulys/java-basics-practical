package study.javaorder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductCatalog {
    private final Map<String, Product> products = new HashMap<>();
    private final Set<Product> registeredProducts = new HashSet<>();

    public boolean register(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("상품이 필요합니다.");
        }
        if (!registeredProducts.add(product)) {
            return false;
        }
        products.put(product.getCode(), product);
        return true;
    }

    public Product find(String productCode) {
        return products.get(productCode);
    }

    public Product findRequired(String productCode) {
        if (productCode == null || productCode.isBlank()) {
            throw new IllegalArgumentException("상품 코드를 입력해 주세요.");
        }
        Product product = products.get(productCode.strip());
        if (product == null) {
            throw new IllegalArgumentException("등록하지 않은 상품입니다: " + productCode);
        }
        return product;
    }

    public int size() {
        return products.size();
    }
}
