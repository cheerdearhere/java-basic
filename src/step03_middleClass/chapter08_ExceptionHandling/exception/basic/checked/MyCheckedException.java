package step03_middleClass.chapter08_ExceptionHandling.exception.basic.checked;

/**
 * Exception 상속 = 체크 예외
 */
public class MyCheckedException extends Exception{
    public MyCheckedException(String message){
        super(message);
    }
}
