package step02_basic.chapter07_virtalMachine.javaMemory4.static_method2;
import static step02_basic.chapter07_virtalMachine.javaMemory4.static_method2.DecoData.*;
public class DecoMain {
    public static void main(String[] args) {
//        DecoData.instanceCall();//NullPointer
        DecoData.staticCall();

        DecoData decoData = new DecoData();
        decoData.instanceCall();
        decoData.staticCall();//사용은 가능

        DecoData.useInstance(decoData);
    }
}
