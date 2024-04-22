package step03_middleClass.chapter05_Enum.type_safeEnum;

import step03_middleClass.chapter05_Enum.useConstant.StringGrade;

public class DiscountMain {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscount = discountService.discount(ClassGrade.BASIC, price);
        int goldDiscount = discountService.discount(ClassGrade.GOLD, price);
        int diamondDiscount = discountService.discount(ClassGrade.DIAMOND, price);

        //parameter 정보를 오해해 객체를 사용하는 경우
//        ClassGrade classGrade = new ClassGrade();
//        int misunderDiscount = discountService.discount(classGrade, price);
        //null 사용
        int nullDiscount = discountService.discount(null, price);
        
        System.out.print(
            "Basic: " + basicDiscount
            + "\nGold: " + goldDiscount
            + "\nDiamond: " + diamondDiscount
            +"\n"
        );
    }
}
