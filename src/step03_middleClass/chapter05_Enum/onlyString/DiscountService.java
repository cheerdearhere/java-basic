package step03_middleClass.chapter05_Enum.onlyString;

public class DiscountService {
    public int discount (String grade, int price){
        if(grade==null||grade.isBlank()||price<1) return price;

        int discountPercent = 0;

        if(grade.equals("BASIC")) discountPercent = 10;
        else if (grade.equals("GOLD")) discountPercent=20;
        else if (grade.equals("DIAMOND")) discountPercent=30;
        else System.out.println(grade+": 할인 x ");

        return price*discountPercent/100;
    }
}
