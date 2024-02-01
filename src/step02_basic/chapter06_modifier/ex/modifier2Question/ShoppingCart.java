package step02_basic.chapter06_modifier.ex.modifier2Question;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;
//    constructor
    public ShoppingCart(){
        itemCount = 0;
    }
//    public methods
    public void addItem(Item item){
        if(isOver()) {
            System.out.println("장바구니가 가득찼습니다.");
            return;
        }
        items[itemCount]=item;
        itemCount++;
    }
    public void displayItems(){
        StringBuilder messageBuilder = new StringBuilder()
                .append("장바구니 상품 출력")
                .append(getItemList(items))
                .append("\n전체 가격 합: ")
                .append(getAllCost(items))
                .append("원");
        System.out.println(messageBuilder);
    }

//    private methods
    /**
     * 추가한 상품이 10개를 채운 경우 true
     */
    private boolean isOver(){
        return itemCount==items.length;
    }

    /**
     * 상품 이름과 각 상품의 가격 정보를 문자열로 전달
     * @param items 담긴 상품 정보 배열
     * @return 문자열
     *      상품명: %s, 합계: %d원
     *      상품명: %s, 합계: %d원
     *      ...
     */
    private String getItemList(Item[] items){
        return Arrays.stream(items)
                .filter(item->item!=null)
                .map(item->String.format(
                        "\n상품명: %s, 합계: %d원",
                        item.getItemName(),
                        item.getCost()))
                .collect(Collectors.joining());
    }

    /**
     * 선택한 상품들의 총 결재금액
     * @param items 상품 목록
     * @return 총 합산 금액
     */
    private int getAllCost(Item[] items){
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .mapToInt(Item::getCost)
                .sum();
    }
}
