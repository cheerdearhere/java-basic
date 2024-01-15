package chapter03_condition;

import java.util.Random;

public class Condition2 {
    public static void main(String[] args){
        Random r = new Random();
        int grade = r.nextInt(0,10);
        int coupon;
// 기존 switch문
        switch (grade){
            case 0 :
                coupon = 500;
                break;
            case 1:
            case 2: //같은 결과인경우
                coupon = 1000;
                break;
            case 3:
                coupon = 3200;
                break;
            case 4:
                coupon = 4300;
                break;
            default:
                coupon = grade * 1500;
        }
        System.out.println("당신의 점수는 "+grade+"점 입니다. 사용할 수 있는 쿠폰은 "+coupon+"원 입니다.");
//  java 14에서 추가된 switch문
        System.out.println("after java 14");
        int coupon14 = switch (grade){
            case 1 -> 1400;
            case 2 -> 2400;
            case 3 -> 3800;
            case 4 -> 5200;
            default -> grade*2400;
        };
        System.out.println("coupon14 = " + coupon14);
    }
}
