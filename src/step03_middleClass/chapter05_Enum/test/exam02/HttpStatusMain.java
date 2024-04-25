package step03_middleClass.chapter05_Enum.test.exam02;

import java.util.Scanner;

/*
문제와 풀이2
문제 설명
enumeration.test.http 패키지를 사용하자.
HttpStatus 열거형을 만들어라.
HTTP 상태 코드 정의
    OK
        code: 200
        message: "OK"
    BAD_REQUEST
        code: 400
        message: "Bad Request"
    NOT_FOUND
        code: 404
        message: "Not Found"
    INTERNAL_SERVER_ERROR
        code: 500
        message: "Internal Server Error"
참고: HTTP 상태 코드는 200 ~ 299사이의 숫자를 성공으로 인정한다.

다음 HttpStatus 열거형을 완성해라. HttpStatusMain 코드와 실행 결과를 참고하자.
    package enumeration.test.http;
    public enum HttpStatus {
     // 코드 작성
    }

    package enumeration.test.http;
    import java.util.Scanner;
    public class HttpStatusMain {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("HTTP CODE: ");
    int httpCodeInput = scanner.nextInt();
    HttpStatus status = HttpStatus.findByCode(httpCodeInput);
    if (status == null) {
    System.out.println("정의되지 않은 코드");
    } else {
    System.out.println(status.getCode() + " " + status.getMessage());
    System.out.println("isSuccess = " + status.isSuccess());
    }
    }
    }

실행 결과
    HTTP CODE: 200
    200 OK
    isSuccess = true

    HTTP CODE: 400
    400 Bad Request
    isSuccess = false

    HTTP CODE: 404
    404 Not Found
    isSuccess = false

    HTTP CODE: 500
    500 Internal Server Error
    isSuccess = false
 */
public class HttpStatusMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("HTTP CODE: ");
        int httpCodeInput = scanner.nextInt();
        HttpStatus status = HttpStatus.findByCode(httpCodeInput);
        if (status == null) {
            System.out.println("정의되지 않은 코드");
        } else {
            System.out.println(status.getCode() + " " + status.getMessage());
            System.out.println("isSuccess = " + status.isSuccess());
        }
    }

}
