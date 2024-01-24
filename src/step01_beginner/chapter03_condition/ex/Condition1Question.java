package step01_beginner.chapter03_condition.ex;

import java.util.Random;

public class Condition1Question {
    /*
    문제1. 학점계산하기
    학생의 점수를 기반으로 학점을 출력하는 프로그램을 작성
        90 이상 > A
        80 이상 90 미만 > B
        70 이상 80 미만 > C
        60 이상 70 미만 > D
        60 미만 F
        각 점수대에서 F를 제외하고
            0~3 > -
            4~6 > 0
            7~9 > +
     */
    public static void main(String[] args){
        Random r = new Random();
        int score = r.nextInt(50,100);
        int i = score % 10;
        String gradeSign = i < 4
                ? "-"
                : i<7
                    ? "0"
                    : "+";
        String grade;
        if(score >= 90) grade = gradeSign+"A";
        else if(score >= 80) grade = gradeSign+"B";
        else if(score >= 70) grade = gradeSign+"C";
        else if(score >= 60) grade = gradeSign+"D";
        else grade = "F";
        System.out.println(score+"점 \n 학점: "+grade);
    }
}
