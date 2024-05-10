package step03_middleClass.chapter08_ExceptionHandling.exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException{
        //예외 상황
        throw new MyCheckedException("example");
    }
}
