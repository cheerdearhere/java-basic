package step04_middleClass2.chapter02_CollectionFramework.test.map;

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("사과", 1000), 1);
        cart.add(new Product("바나나", 500), 1);
        cart.printAll();
        cart.add(new Product("사과", 1000), 2);
        cart.printAll();
        cart.minus(new Product("사과", 1000), 3);
        cart.printAll();
    }
}
