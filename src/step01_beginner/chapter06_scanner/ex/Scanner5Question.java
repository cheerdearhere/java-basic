package step01_beginner.chapter06_scanner.ex;

import java.util.Scanner;

public class Scanner5Question {
/*
사용자로부터 이름과 나이를 반복해서 입력받고,
입력받은 이름과 나이를 출력하는 프로그램을 작성하세요.
사용자가 "종료"를 입력하면 프로그램이 종료되어야 합니다.
다음 실행 결과 예시를 참고해주세요.
    이름을 입력하세요 (종료를 입력하면 종료): 자바
    나이를 입력하세요: 30
    입력한 이름: 자바, 나이: 30
    이름을 입력하세요 (종료를 입력하면 종료): 하니
    나이를 입력하세요: 20
    입력한 이름: 하니, 나이: 20
    이름을 입력하세요 (종료를 입력하면 종료): 종료
    프로그램을 종료합니다
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterator = 0;
        while(true){
            ++iterator;
            System.out.println(iterator+". 이름을 입력하세요. (이름에 '종료'를 입력하면 프로그램이 종료됩니다.)");
            String name = scanner.nextLine();
            if(name.equals("종료")){
                System.out.println("프로그램을 종료합니다. ");
                break;
            }
            System.out.println("나이를 입력하세요. ");
            int age = scanner.nextInt();
            while(age<=0) {
                System.out.println("나이는 0보다 커야합니다.");
                age= scanner.nextInt();
            }
            System.out.println("입력한 이름: "+name+" 나이: "+age);
            scanner.nextLine();
        }
        scanner.close();
    }
}
