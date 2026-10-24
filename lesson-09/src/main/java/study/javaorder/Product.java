package study.javaorder;

import java.util.Objects;

public class Product {
    private final String code;
    private final String name;
    private final long unitPrice;
    private final String category;

    public Product(
            String code, String name,
            long unitPrice, String category) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public String getCategory() {
        return category;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(code, other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
