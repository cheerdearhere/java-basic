package step02_basic.chapter05_package.package2.com.helloshop.order;

public class OrderHistory {

    public void saveHistory(Order order){
        System.out.printf("%s님(%s) 주문: %s - %d",
                order.user.getName(),
                order.user.getUserId(),
                order.product.getProductId(),
                order.product.getPrice()
        );
    }
}
