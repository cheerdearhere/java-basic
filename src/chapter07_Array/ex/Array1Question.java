package chapter07_Array.ex;

public class Array1Question {
    /*
    문제1: 다음 문제를 배열을 사용해서 개선하자
    int student1 = 90;
    int student2 = 80;
    int student3 = 70;
    int student4 = 60;
    int student5 = 50;
    int total = student1 + student2 + student3 + student4 + student5;
    double average = (double) total / 5;
    System.out.println("점수 총합: " + total);
    System.out.println("점수 평균: " + average);
     */
    public static void main(String[] args) {
        int[] strudents = {90,80,70,60,50};

        int total=0;
        double average;

        for (int strudent : strudents) {
            total+=strudent;
        }
        average=(double)total/strudents.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
