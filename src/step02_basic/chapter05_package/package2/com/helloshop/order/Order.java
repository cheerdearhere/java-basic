package step02_basic.chapter05_package.package2.com.helloshop.order;

import step02_basic.chapter05_package.package2.com.helloshop.product.Product;
import step02_basic.chapter05_package.package2.com.helloshop.user.User;

public class Order {
//    long orderSeq;
    User user;
    Product product;

    public Order(User user, Product product){
        this.user = user;
        this.product = product;
    }
}
