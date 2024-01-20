package chapter06_scanner.basic;

import java.util.Scanner;

public class Scanner1_6 {
    /*
        사용자로부터 이름과 나이를 입력받아 다음과 같이 출력
        "당신의 이름은 [이름]이고, 나이는 [나이]입니다."
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        String escapeKey;
        while (true){
            System.out.println("이름을 입력하세요.");
            name = scanner.nextLine();
            System.out.println("나이를 입력하세요.");
            age = scanner.nextInt();
            while (age<=0){
                System.out.println("나이는 0보다 커야합니다. 다시입력해주세요. ");
                age = scanner.nextInt();
            }
            System.out.println("당신의 이름은 "+name+"이고, 나이는 "+age+"입니다.");
            System.out.println("\n 종료를 원하시면 exit를, 반복하시려면 아무 키나 입력하세요.");
            scanner.nextLine();//nextInt 이후 다시 line을 받는 경우 클리어 필요
            escapeKey = scanner.nextLine();

            if(escapeKey.equalsIgnoreCase("exit")){
                System.out.println("종료");
                break;
            }
        }
        scanner.close();
    }
}
