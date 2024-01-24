package step01_beginner.chapter03_condition.ex;

import java.util.Random;

public class Condition5Question {
    /*
    문제5. 학점에 따른 성취도 출력
    A > 탁월한 성과입니다.
    B > 좋은 성과입니다.
    C > 준수한 성과입니다.
    D > 향상이 필요합니다.
    F > 불합격입니다.
    나머지 > 잘못된 학점입니다.
     */
    public static void main(String[] args) {
        Random r = new Random();
        int score = r.nextInt(50,100);

        String grade;
        if(score >= 90) grade = "A";
        else if(score >= 80) grade = "B";
        else if(score >= 70) grade = "C";
        else if(score >= 60) grade = "D";
        else grade = "F";

        String message = switch (grade){
            case "A" -> "탁월한 성과입니다.("+grade+", "+score+")";
            case "B" -> "좋은 성과입니다.("+grade+", "+score+")";
            case "C" -> "준수한 성과입니다.("+grade+", "+score+")";
            case "D" -> "향상이 필요합니다.("+grade+", "+score+")";
            case "F" -> "불합격 입니다.("+grade+", "+score+")";
            default -> "잘못된 학접입니다.("+grade+", "+score+")";
        };
        System.out.println(message);
    }
}
