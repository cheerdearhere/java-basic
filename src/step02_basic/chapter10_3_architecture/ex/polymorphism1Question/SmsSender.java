package step02_basic.chapter10_3_architecture.ex.polymorphism1Question;

public class SmsSender implements Sender{

    @Override
    public void sendMessage(String message) {
        System.out.println("SMS를 발송합니다: "+message);
    }
}
