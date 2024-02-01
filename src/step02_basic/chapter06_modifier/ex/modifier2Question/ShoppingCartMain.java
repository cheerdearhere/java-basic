package step02_basic.chapter06_modifier.ex.modifier2Question;

public class ShoppingCartMain {
/*
문제2 - 쇼핑 카트
ShoppingCartMain 코드가 작동하도록 Item , ShoppingCart 클래스를 완성해라.
요구사항
    접근 제어자를 사용해서 데이터를 캡슐화 하세요.
    해당 클래스는 다른 패키지에서도 사용할 수 있어야 합니다.
    장바구니에는 상품을 최대 10개만 담을 수 있다.
    10개 초과 등록시: "장바구니가 가득 찼습니다." 출력
실행 결과
    장바구니 상품 출력
    상품명:마늘, 합계:4000
    상품명:상추, 합계:12000
    전체 가격 합:16000

    main class
        public class ShoppingCartMain {
         public static void main(String[] args) {
         ShoppingCart cart = new ShoppingCart();
         Item item1 = new Item("마늘", 2000, 2);
         Item item2 = new Item("상추", 3000, 4);
         cart.addItem(item1);
         cart.addItem(item2);
         cart.displayItems();
         }
        }
    Item 클래스
        public class Item {
         private String name;
         private int price;
         private int quantity;
         //TODO 나머지 코드를 완성해라.
        }

    ShoppingCart 클래스
        public class ShoppingCart {
         private Item[] items = new Item[10];
         private int itemCount;
         //TODO 나머지 코드를 완성해라.
        }
*/
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.displayItems();
    }
}
