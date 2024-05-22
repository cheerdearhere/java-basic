package step04_middleClass2.chapter02_CollectionFramework.test.list;


import java.util.ArrayList;
import java.util.List;

/*
문제 - 쇼핑카트
    ShoppingCartMain 코드가 작동하도록 ShoppingCart 클래스를 완성해라.
    ShoppingCart 는 내부에 리스트를 사용해야 한다.
실행 결과
    장바구니 상품 출력
    상품명:마늘, 합계:4000
    상품명:상추, 합계:12000
    전체 가격 합:16000
 */
public class ShoppingCart {
    private final List<Item> items = new ArrayList<Item>();
    public void addItem(Item item) {
        items.add(item);
    }
    public void displayItems(){
//        System.out.println("장바구니 상품 출력");
//        for(Item item : items){
////            totalPrice += item.getTotalPrice();
//            System.out.println("상품 명: "+item.getName()+", 합계: "+item.getTotalPrice());
//        }
//        // 위의 코드와 합쳐서 합계도 한번에 처리하는게 더 효율적이지만
//        // 크게 문제는 되지 않으므로 가독성을 위해 아래에 배치...
//        System.out.println("전체 가격 합: "+calculateTotalPrice());

        StringBuilder sb = new StringBuilder("장바구니 상품 출력\n");
        items.forEach(item->{
            sb.append("상품 명: ").append(item.getName()).append(", 합계: ").append(item.getTotalPrice()).append("\n");
        });
        sb.append("전체 가격 합: ").append(calculateTotalPrice()).append("\n");
        System.out.println(sb);
    }

    private int calculateTotalPrice(){
//        int totalPrice = 0;
//        for(Item item : items){
//            totalPrice += item.getTotalPrice();
//        }
//        return totalPrice;
        return items.stream().mapToInt(Item::getTotalPrice).sum();
    };
}
