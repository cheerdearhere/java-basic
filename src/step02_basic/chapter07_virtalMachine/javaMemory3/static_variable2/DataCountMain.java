package step02_basic.chapter07_virtalMachine.javaMemory3.static_variable2;

public class DataCountMain {
    public static void main(String[] args) {
        Data data1 = new Data("A");
        System.out.println("A count = "+data1.getCount());
        Data data2 = new Data("B");
        System.out.println("B count = "+data2.getCount());
        Data data3 = new Data("C");
        System.out.println("C count = "+data3.getCount());

        System.out.println(Data.staticVariable);

    }
}
