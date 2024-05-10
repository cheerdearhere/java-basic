package step03_middleClass.chapter08_ExceptionHandling.exception.basic.unchecked;

import javax.swing.*;

/**
 * Unchecked Exception
 * 예외를 잡거나 던지지 않아도 자동으로 외부로 던짐
 */
public class Service {
    Client client = new Client();
    public void callCatch(){
        try{
            client.call();
        }
        catch(MyUncheckedException mue){
            System.out.println("에러 메세지] "+mue.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("정상 로직");
    }
    public void callThrows(){
        client.call();
    }
}
