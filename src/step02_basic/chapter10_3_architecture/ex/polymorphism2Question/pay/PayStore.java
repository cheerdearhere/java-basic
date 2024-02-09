package step02_basic.chapter10_3_architecture.ex.polymorphism2Question.pay;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PayStore {
    public static String[] payArr = {"kakao","naver"};
    public static String getPayList(){
        return String.join(", ", payArr);
    }
    public static Pay findPay(String option){
        if (option.equals(payArr[0])) {
            return new KakaoPay();
        } else if (option.equals(payArr[1])) {
            return new NaverPay();
        } else {
//            System.out.println("결제 수단이 없습니다.");
//            return null; NullObject pattern: null을 사용하기보다 default용 class를 만들어 사용
            return new DefaultPay();
        }
    }
}
