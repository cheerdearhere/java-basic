package step02_basic.chapter05_package.package2.com.helloshop.order;

import step02_basic.chapter05_package.package2.com.helloshop.product.Product;
import step02_basic.chapter05_package.package2.com.helloshop.user.User;

public class OrderService {
    Order order;
    public void setOrder(User user,Product product){
        order = new Order(user,product);
    }
    public Order getOrder(){
        return this.order;
    }
}
