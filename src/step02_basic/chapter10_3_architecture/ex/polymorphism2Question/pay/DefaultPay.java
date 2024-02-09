package step02_basic.chapter10_3_architecture.ex.polymorphism2Question.pay;

/**
 * Pay 선택지에 없는 경우 null 대신 사용
 */
public class DefaultPay implements Pay{
    @Override
    public boolean pay(int amount){
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
