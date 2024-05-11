package step03_middleClass.chapter08_ExceptionHandling.example04_checkedException;




import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) throws NetworkClientException {
//        NetworkServiceV1 networkService = new NetworkServiceV1();
//        NetworkServiceV2 networkService = new NetworkServiceV2();
//        NetworkServiceV3 networkService = new NetworkServiceV3();
        NetworkServiceV4 networkService = new NetworkServiceV4();
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
