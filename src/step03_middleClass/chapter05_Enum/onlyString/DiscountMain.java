package step03_middleClass.chapter05_Enum.onlyString;

public class DiscountMain {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount("BASIC", price);
        int goldDiscount = discountService.discount("GOLD", price);
        int diamondDiscount = discountService.discount("DIAMOND", price);

        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
}
