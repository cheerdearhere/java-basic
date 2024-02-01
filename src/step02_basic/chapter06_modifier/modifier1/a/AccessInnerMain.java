package step02_basic.chapter06_modifier.modifier1.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        //클래스 내부접근
        AccessData innerAccessData = new AccessData();
        innerAccessData.innerAccess();

        //클래스 외부, 같은 패키지 내부
        String samePackageMessage = "\n   package 내부 접근 완료";
        AccessData data = new AccessData();
        data.publicField += samePackageMessage;
        data.defaultField += samePackageMessage;
//        data.privateField += samePackageMessage; 접근 불가

        data.publicMethod();
        data.defaultMethod();
//        data.priavateMathod(); 접근 불가
    }
}
