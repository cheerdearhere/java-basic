package step03_middleClass.chapter08_ExceptionHandling.exception.basic.unchecked;

public class Client {
    public void call(){
        throw new MyUncheckedException("unchecked exception example");
    }
}
