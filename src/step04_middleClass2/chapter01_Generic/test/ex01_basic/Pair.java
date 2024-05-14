package step04_middleClass2.chapter01_Generic.test.ex01_basic;

public class Pair <T, U>{
    private T first;
    private U second;

    public void setFirst(T t) {
        this.first = t;
    }
    public void setSecond(U u) {
        this.second = u;
    }
    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
