package step03_middleClass.chapter05_Enum.refactoring;

import static step03_middleClass.chapter05_Enum.refactoring.Grade.*;
//import static step03_middleClass.chapter05_Enum.refactoring.ClassGrade.*;

public class DiscountMain {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        int price = 10000;

//        int basicDiscount = discountService.discount(BASIC, price);
//        int goldDiscount = discountService.discount(GOLD, price);
//        int diamondDiscount = discountService.discount(DIAMOND, price);
        //        Grade grade = new Grade();
        System.out.print(
            "Basic: " + BASIC.getDiscountPrice(price)
            + "\nGold: " + GOLD.getDiscountPrice(price)
            + "\nDiamond: " + DIAMOND.getDiscountPrice(price)
            +"\n"
        );

        printDiscountInfo(price);

//        printDiscountInfo(BASIC, price);
//        printDiscountInfo(GOLD, price);
//        printDiscountInfo(DIAMOND, price);
        for(Grade grade: Grade.values()){
            printDiscountInfo(grade.getDiscountPrice(price));
        }

    }
    private static void printDiscountInfo(int price) {
        System.out.print(
                "## information about the discount\n"
                + "\t - " + BASIC.name() + " 등급의 할인 금액: " + BASIC.getDiscountPrice(price) + "\n"
                + "\t - " + GOLD.name() + " 등급의 할인 금액: " + GOLD.getDiscountPrice(price) + "\n"
                + "\t - " + DIAMOND.name() + " 등급의 할인 금액: " + DIAMOND.getDiscountPrice(price) + "\n"
        );
    }
    private static void printDiscountInfo(Grade grade, int price) {
        System.out.print(grade.name() + " 등급의 할인 금액: " + grade.getDiscountPrice(price));
    }
}
