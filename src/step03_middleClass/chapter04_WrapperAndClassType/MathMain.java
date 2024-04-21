package step03_middleClass.chapter04_WrapperAndClassType;

import step02_basic.chapter02_variable.variable4.BigData;

import java.math.BigDecimal;

public class MathMain {
    public static void main(String[] args) {
        //기본 연산
        System.out.println("max(10,23): "+Math.max(10,23));
        System.out.println("min(10,23): "+Math.min(10,23));
        System.out.println("abs(-10): "+Math.abs(-10));

        //반올림, 정밀도
        System.out.println("올림 - ceil(2.1): "+Math.ceil(2.1));
        System.out.println("내림 - floor(2.1): "+Math.floor(2.1));
        System.out.println("가까운 정수 - rint(2.1): "+Math.rint(2.1));
        System.out.println("반올림 - round(2.1): "+Math.round(2.1));

        //기타
        System.out.println("제곱근 - sqrt(10): "+Math.sqrt(16));
        System.out.println("세제곱근 - cbrt(-8): "+Math.cbrt(-8));
        System.out.println("0~1 랜덤 - random(): "+Math.random());

        BigDecimal bigDecimal = new BigDecimal("0.1");
    }
}
