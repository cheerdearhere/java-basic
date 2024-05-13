package step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException;

import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.AnotherNetworkException;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.NetworkClientException;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.ConnectException;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.SendException;

import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) {
        NetworkServiceV1 networkService = new NetworkServiceV1();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("전송할 문자(종료:exit): ");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")) {
                break;
            }
            try{
                networkService.sendMessage(input);
                System.out.println();
            }
            catch(Exception e){
                //공통 예외 처리
                exceptionHandler(e);
            }
        }
        System.out.println("프로그램을 정상 종료합니다. ");
    }

    /**
     * 공통 예외 처리
     * @param e Exception object
     */
    private static void exceptionHandler(Exception e) {
        System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다");
        System.out.println("==== 개발자용 디버깅 메시지 ====");

        if(e instanceof SendException sendException) {
            System.out.println("[전송 오류] 코드: "+sendException.getStatusCode()+"/ data: "+sendException.getSendData()+"/ 메시지: "+sendException.getMessage());
        }
        else if(e instanceof AnotherNetworkException anotherNetworkException | e instanceof ConnectException connectException) {
            System.out.println("[연결 오류] 코드: "+e.getClass().getName()+" / 메시지: "+e.getMessage());
        }
        else if(e instanceof NetworkClientException networkClientException) {
            System.out.println("[네트워크 오류] 코드: "+networkClientException.getStatusCode()+" 메시지: "+e.getMessage());
        }
        else{
            System.out.println("[알 수 없는 오류] 에러 클래스: "+e.getClass().getName()+" 메시지: "+e.getMessage());
        }
        e.printStackTrace(System.out);
    }
}
