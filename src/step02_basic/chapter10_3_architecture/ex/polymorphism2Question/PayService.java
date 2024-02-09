package step02_basic.chapter10_3_architecture.ex.polymorphism2Question;

import step02_basic.chapter10_3_architecture.ex.polymorphism2Question.pay.*;

public class PayService {
    public void processPay(String option, int amount) {
//        boolean result=false;
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

        Pay pay=PayStore.findPay(option);//결재 수단을 보관하는 class
//        if (pay != null) {null 입력 자체를 안하기위해 NullObject pattern 사용
//            result=pay.pay(amount);
//        }
        boolean result=pay.pay(amount);
        System.out.println(result?"결제가 성공했습니다.":"결제가 실패했습니다.");
    }
}
