package step04_middleClass2.chapter02_CollectionFramework.test.list;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayEx02 {
    public static void main(String[] args) {
        /*
        문제2 설명
        사용자에게 n 개의 정수를 입력받아서 List 에 저장하고, 입력 순서대로 출력하자.
        0 을 입력하면 입력을 종료하고 결과를 출력한다.
        출력시 출력 포멧은 1, 2, 3, 4, 5와 같이 , 쉼표를 사용해서 구분하고, 마지막에는 쉼표를 넣지 않아야 한다.
        실행 결과 예시를 참고하자.
        실행 결과
            n개의 정수를 입력하세요 (종료 0)
            1
            2
            3
            4
            5
            0
            출력
            1, 2, 3, 4, 5
         */
        System.out.println("문제2: 데이터 추가");
        Scanner scanner = new Scanner(System.in);
        System.out.println("n개의 정수를 입력하세요 (종료: 0)");
        List<Integer> intInteger1 = new ArrayList<>();

        while(true){
            int input = scanner.nextInt();
            if(input == 0){
                break;
            }
            intInteger1.add(input);
        }
        scanner.close();
        System.out.println("출력");
        for(int i=0;i<intInteger1.size();i++){
            System.out.print(intInteger1.get(i));
            if(i!=intInteger1.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
