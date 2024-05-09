package step03_middleClass.chapter08_ExceptionHandling.example02_occurredError;

import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) {
        NetworkService networkService = new NetworkService();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("전송할 문자(종료:exit): ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")) {
                break;
            }
            networkService.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다. ");
    }
}
