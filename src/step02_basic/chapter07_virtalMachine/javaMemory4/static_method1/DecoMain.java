package step02_basic.chapter07_virtalMachine.javaMemory4.static_method1;

public class DecoMain {
    public static void main(String[] args) {
        String s = "hello";
        String deco = DecoUtil.decoStr(s);

        System.out.println("s = " + s);
        System.out.println("deco = " + deco);
    }
}
