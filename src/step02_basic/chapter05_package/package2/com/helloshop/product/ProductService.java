package step02_basic.chapter05_package.package2.com.helloshop.product;

public class ProductService {
    public Product selectProduct(String productId, int price){
        return new Product(productId,price);
    }
}
