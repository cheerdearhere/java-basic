package chapter07_Array.ex;

import java.util.Scanner;

public class Array8Question {
    /*
    문제8 - 2차원 배열2
    이전 문제에서 학생수를 입력받도록 개선하자.
    실행 결과 예시를 참고하자.
        실행 결과 예시
        학생수를 입력하세요:3
        1번 학생의 성적을 입력하세요:
        국어 점수:10
        영어 점수:20
        수학 점수:30
        2번 학생의 성적을 입력하세요:
        국어 점수:10
        영어 점수:10
        수학 점수:10
        3번 학생의 성적을 입력하세요:
        국어 점수:20
        영어 점수:20
        수학 점수:20
        1번 학생의 총점: 60, 평균: 20.0
        2번 학생의 총점: 30, 평균: 10.0
        3번 학생의 총점: 60, 평균: 20.0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] scores;
        String[] subject = {"국어","영어","수학"};
        int studentNum;
        int temp;
        int sum;
        double avg;

        System.out.println("학생 수를 입력하세요.");
        studentNum = scanner.nextInt();
        scores = new int[studentNum][subject.length];
        for(int i=0;i<scores.length;i++){
            System.out.println((i+1)+"번 학생의 성적을 입력하세요: ");
            for(int j=0;j<scores[i].length;j++){
                System.out.println(subject[j]+":");
                temp = scanner.nextInt();
                scores[i][j]=temp;
            }
        }
        scanner.close();
        for(int i=0;i<scores.length;i++){
            sum = 0;
            for(int score:scores[i]){
                sum+=score;
            }
            avg =(double)sum/scores[i].length;
            System.out.println((i+1)+"번 학생 총점: "+sum+" 평균: "+avg);
        }
    }

}
