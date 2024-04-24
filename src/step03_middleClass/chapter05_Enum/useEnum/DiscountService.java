package step03_middleClass.chapter05_Enum.useEnum;

import static step03_middleClass.chapter05_Enum.useEnum.Grade.*;

public class DiscountService {
    public int discount (Grade grade, int price){
        if(grade==null||price<1) return price;

        int discountPercent = 0;

        if(grade==BASIC) discountPercent = 10;
        else if (grade==GOLD) discountPercent=20;
        else if (grade==DIAMOND) discountPercent=30;
        else System.out.println(": 할인 x ");

        return price*discountPercent/100;
    }
    public void showGradeClass(){
        System.out.println("class Basic: "+ BASIC.getClass());
        System.out.println("class Gold: "+GOLD.getClass());
        System.out.println("class Diamond: "+DIAMOND.getClass());
    }
    public void showRefValue(Grade grade){
        System.out.println("ref: "+Integer.toHexString(System.identityHashCode(grade)));
    }
}
