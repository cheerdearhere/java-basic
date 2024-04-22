package step03_middleClass.chapter05_Enum.useConstant;

public class DiscountMain {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount(StringGrade.BASIC, price);
        int goldDiscount = discountService.discount(StringGrade.GOLD, price);
        int diamondDiscount = discountService.discount(StringGrade.DIAMOND, price);

        int errorDiscount = discountService.discount("Error",price);
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
}
