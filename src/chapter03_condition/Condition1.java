package chapter03_condition;

import java.util.Random;

public class Condition1 {
    public static void main(String[] args) {
        //int age = 20;
        Random random = new Random();
        int age = random.nextInt(1,30);
        System.out.println("age = " + age);
//        if만 사용
        if(age >= 18){
            System.out.println("성인입니다.");
        }
        if(age<18){
            System.out.println("미성년자입니다.");
        }
//        else 사용
        if( age >= 18){
            System.out.println("성인입니다2");
        }
        else{
            System.out.println("미성년자입니다. ");
        }
//        if-else if-else
        if(age<12){
            System.out.println("소년, 소녀");
        }
        else if(age<18){
            System.out.println("청소년");
        }
        else{
            System.out.println("성인");
        }
//    각 조건이 독립적일때는 if문 사용
        int price = random.nextInt(1000,30000);
        int discount = 0;
        if(price >= 10000){
            discount += 1000;
            System.out.println("만원이상 구매: 1000원 할인");
        }
        if(age <= 10){
            discount += 1000;
            System.out.println("어린이 손님: 1000원 할인");
        }
        System.out.println("기본 가격: "+price+"원/ 총 할인 금액: "+discount+"원/ 결제금액: "+(price-discount)+"원");
//     if-else if를 사용하면 둘중 하나만
        if(price >= 10000){
            discount += 1000;
            System.out.println("만원이상 구매: 1000원 할인");
        }
        else if(age <= 10){
            discount += 1000;
            System.out.println("어린이 손님: 1000원 할인");
        }
        System.out.println("if else>> 기본 가격: "+price+"원/ 총 할인 금액: "+discount+"원/ 결제금액: "+(price-discount)+"원");
    }

}
