package step03_middleClass.chapter03_StringClass.methodChaining;

public class MethodChainingMain {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();
        ValueAdder ref1 = adder.add(1);
        ValueAdder ref2 = adder.add(2);
        ValueAdder ref3 = adder.add(3);
        ValueAdder ref4 = adder.add(4);
        
        int result = adder.getValue();

        System.out.println("ref1 = " + ref1);
        System.out.println("ref2 = " + ref2);
        System.out.println("ref3 = " + ref3);
        System.out.println("ref4 = " + ref4);

        //this(자신의 reference)를 반환하므로 결과에 다시 메서드를 호출할 수 있어 연속적 처리가 가능하다
        adder.add(5).add(6).add(7).add(8).add(9).add(10);
        System.out.println("adder = " + adder.getValue());

        StringBuilder sb = new StringBuilder();
        String str = sb.append("a").append("b").append("c").append("d").append("e").append("f")
                .insert(4,"Java!")
                .delete(4,8)
                .reverse()
                .toString();
        System.out.println("str = " + str);
    }
}
