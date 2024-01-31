package step02_basic.chapter05_package.package2.com.helloshop.product;

public class Product {
    String productId;
    int price;
    public Product(String productId, int price){
        this.productId = productId;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public int getPrice() {
        return price;
    }
}
