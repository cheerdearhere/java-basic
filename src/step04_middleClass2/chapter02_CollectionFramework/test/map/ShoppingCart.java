package step04_middleClass2.chapter02_CollectionFramework.test.map;

import java.util.HashMap;
import java.util.Map;

/*
문제7 - 장바구니
문제 설명
장바구니 추가 - add()
장바구니에 상품과 수량을 담는다. 상품의 이름과 가격이 같으면 같은 상품이다.
장바구니에 이름과 가격이 같은 상품을 추가하면 기존에 담긴 상품에 수량만 추가된다.
장바구니에 이름과 가격이 다른 상품을 추가하면 새로운 상품이 추가된다.
장바구니 제거 - minus()
장바구니에 담긴 상품의 수량을 줄일 수 있다. 만약 수량이 0보다 작다면 상품이 장바구니에서 제거된다.
CartMain 과 실행 결과를 참고해서 Product , Cart 클래스를 완성하자.
Cart 클래스는 Map 을 통해 상품을 장바구니에 보관한다.
Map 의 Key는 Product 가 사용되고, Value는 장바구니에 담은 수량이 사용된다.

package collection.map.test.cart;
public class CartMain {
 public static void main(String[] args) {
 Cart cart = new Cart();
 cart.add(new Product("사과", 1000), 1);
 cart.add(new Product("바나나", 500), 1);
 cart.printAll();
 cart.add(new Product("사과", 1000), 2);
 cart.printAll();
 cart.minus(new Product("사과", 1000), 3);
 cart.printAll();
 }
}

==모든 상품 출력==
상품: Product{name='사과', price=1000} 수량: 1
상품: Product{name='바나나', price=500} 수량: 1
==모든 상품 출력==
상품: Product{name='사과', price=1000} 수량: 3
상품: Product{name='바나나', price=500} 수량: 1
==모든 상품 출력==
상품: Product{name='바나나', price=500} 수량: 1
 */
public class ShoppingCart {
    private final Map<Product, Integer> cart = new HashMap<>();

    /**
     * add product
     * @param product target product
     * @param quantity add quantity. if not exist, create new product instance
     */
    public void add(Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product,0)+quantity);
    }
    public void minus(Product product, int quantity) {
        if(!cart.containsKey(product)){
            System.out.println("Product does not exist");
        }
        else if(quantity >= cart.get(product)){
            cart.remove(product);
        }
        else{
            cart.put(product, cart.get(product)-quantity);
        }
    }
    public void printAll(){
        System.out.println("==모든 상품 출력==");
        cart.forEach((k,v)->{
            System.out.printf("상품: Product{name='%s', price=%d} 수량: %d%n", k.getName(), k.getPrice(), v);
        });
    }
}
