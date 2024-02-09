package step02_basic.chapter10_3_architecture.ex.polymorphism1Question;

public class FaceBookSender implements Sender{

    @Override
    public void sendMessage(String message) {
        System.out.println("페이스북에 발송합니다: "+message);
    }
}
