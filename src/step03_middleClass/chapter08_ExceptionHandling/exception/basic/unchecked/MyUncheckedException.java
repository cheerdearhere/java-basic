package step03_middleClass.chapter08_ExceptionHandling.exception.basic.unchecked;
/**
 * RuntimeException 상속 = 언체크 예외
 */
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}
