package step03_middleClass.chapter02_Immutable.example_immutableObject;

public class MemberMain {
    public static void main(String[] args) {
        Address addressS = new Address("서울");

        //두 회원 모두 서울 거주
        MemberV1 memberA = new MemberV1("회원A",addressS);
        MemberV1 memberB = new MemberV1("회원B",addressS);

        // 회원 B가 부산으로 이사
        //memberB.getAddress().setAddress("부산"); 불변객체가 아닌경우
        memberB.setAddress(new Address("부산"));

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
