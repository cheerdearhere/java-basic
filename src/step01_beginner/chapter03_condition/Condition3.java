package step01_beginner.chapter03_condition;

import java.util.Random;

public class Condition3 {
    public static void main(String[] args) {
        Random r = new Random();
        int age = r.nextInt(0,40);
        String status = age >= 18 ? "성인" : "미성년자";
        System.out.println(age+"세는 "+status+" 입니다.");
//        여러 조건을 섞을 수 있음
        String status2 = age >= 18
                ? "성인"
                : age >=13
                    ? "청소년"
                    : "소년";
        System.out.println(status2);
    }
}
