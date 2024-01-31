package step02_basic.chapter04_constructor.constructor1;

public class MemberInitMain {
    public static void main(String[] args) {
        MemberInit defaultMember = new MemberInit();
        MemberInit memberInit1 = new MemberInit("이름만 받는 생성자");
        MemberInit memberInit2 = new MemberInit("모든 데이터를 받음", 11, 60);
        MemberInit memberInit3 = new MemberInit("일부 데이터만 받음",13);
    }
}
