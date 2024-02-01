package step02_basic.chapter06_modifier.modifier1.b;

import step02_basic.chapter06_modifier.modifier1.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        //클래스 내부접근
        AccessData innerAccessData = new AccessData();
        innerAccessData.innerAccess();

        //클래스 외부, 같은 패키지 내부
        String samePackageMessage = "\n   package 외부 접근 완료";
        AccessData data = new AccessData();
        data.publicField += samePackageMessage;
//        data.defaultField += samePackageMessage; 접근 불가
//        data.privateField += samePackageMessage; 접근 불가

        data.publicMethod();
//        data.defaultMethod(); 접근불가
//        data.priavateMathod(); 접근 불가
    }
}
