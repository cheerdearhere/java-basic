package step03_middleClass.chapter02_Immutable.primitiveReference;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableField a = new ImmutableField(10);
        ImmutableField b = a;
//        b.setField(10+1); 필드 수정 불가
        System.out.println("a, b: " + a + ", "+b);
        ImmutableField c = new ImmutableField(10);
//        c.setField(20); 수정불가
        c = new ImmutableField(20);//새로운 객체 생성으로 유도
        System.out.println("a, c: " + a+", "+c);
    }
}
