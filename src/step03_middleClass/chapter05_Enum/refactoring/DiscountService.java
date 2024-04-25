package step03_middleClass.chapter05_Enum.refactoring;

public class DiscountService {
    public int discount (ClassGrade grade, int price){
        if(grade==null||price<1) return price;

//        int discountPercent = 0;
//
//        if(grade==BASIC) discountPercent = 10;
//        else if (grade==GOLD) discountPercent=20;
//        else if (grade==DIAMOND) discountPercent=30;
//        else System.out.println(": 할인 x ");
//
//        return price*discountPercent/100;
        return price * grade.getDiscountPercent() / 100;
    }
    public int discount (Grade grade,int price){
//        if(grade==null) return price;
//        return price * grade.getDiscountPercent() / 100;
        return grade.getDiscountPrice(price);
    }
}
