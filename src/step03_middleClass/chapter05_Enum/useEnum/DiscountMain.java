package step03_middleClass.chapter05_Enum.useEnum;

public class DiscountMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();

        discountService.showGradeClass();
        discountService.showRefValue(Grade.BASIC);
        discountService.showRefValue(Grade.GOLD);
        discountService.showRefValue(Grade.DIAMOND);


        int price = 10000;

        int basicDiscount = discountService.discount(Grade.BASIC, price);
        int goldDiscount = discountService.discount(Grade.GOLD, price);
        int diamondDiscount = discountService.discount(Grade.DIAMOND, price);

//        Grade grade = new Grade();
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
}
