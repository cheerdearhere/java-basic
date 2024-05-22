package step04_middleClass2.chapter02_CollectionFramework.test.list;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayEx03 {
    public static void main(String[] args) {
        /*
        문제3 - 합계와 평균
            사용자에게 n 개의 정수를 입력받아서 List 에 보관하고, 보관한 정수의 합계와 평균을 계산하는 프로그램을 작성하
            자.
            ListEx3 에 작성하자.
        실행 결과 예시
            n개의 정수를 입력하세요 (종료 0)
            1
            2
            3
            4
            5
            0
            입력한 정수의 합계: 15
            입력한 정수의 평균: 3.0
         */
        System.out.println("문제3: 합계와 평균");
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        Scanner scanner2 = new Scanner(System.in);
        List<Integer> intInteger2 = new ArrayList<>();
        while(true){
            int input = scanner2.nextInt();
            if(input == 0){
//                int sum = 0;
//                double average = 0;
//                for(Integer integer : intInteger2){
//                    sum += integer;
//                }
//                average = sum/intInteger2.size();
//                System.out.println("입력한 정수의 합계: "+sum);
//                System.out.println("입력한 정수의 평균: "+average);
                System.out.println("입력한 정수의 합계: "+intInteger2.stream().mapToInt(Integer::valueOf).sum());
                System.out.println("입력한 정수의 평균: "+ intInteger2.stream().mapToInt(Integer::valueOf).average().getAsDouble());
                break;
            }
            else{
                intInteger2.add(input);
            }
        }
        scanner2.close();
    }
}
