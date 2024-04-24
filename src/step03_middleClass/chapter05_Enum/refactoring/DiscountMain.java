package step03_middleClass.chapter05_Enum.refactoring;

import step03_middleClass.chapter05_Enum.refactoring.Grade.*;

import static step03_middleClass.chapter05_Enum.refactoring.Grade.*;

public class DiscountMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        int price = 10000;

        int basicDiscount = discountService.discount(BASIC, price);
        int goldDiscount = discountService.discount(GOLD, price);
        int diamondDiscount = discountService.discount(DIAMOND, price);

//        Grade grade = new Grade();
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
}
