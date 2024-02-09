package step02_basic.chapter10_3_architecture.ex.polymorphism1Question;

public class EmailSender implements Sender{

    @Override
    public void sendMessage(String message) {
        System.out.println("메일을 발송합니다: "+message);
    }
}
