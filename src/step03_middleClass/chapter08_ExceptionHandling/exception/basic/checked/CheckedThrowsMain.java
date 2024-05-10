package step03_middleClass.chapter08_ExceptionHandling.exception.basic.checked;

public class CheckedThrowsMain {
    public static void main(String[] args) throws Exception /*MyCheckedException 포함됨*/ {
        Service service = new Service();
        service.callThrows();
        System.out.println("정상 종료");
    }
}
