package study.javaorder;

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
}
