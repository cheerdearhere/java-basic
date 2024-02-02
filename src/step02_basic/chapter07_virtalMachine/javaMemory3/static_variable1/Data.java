package step02_basic.chapter07_virtalMachine.javaMemory3.static_variable1;

public class Data {
    private String name;
    private int count;
    public Data(String name){
        this.name = name;
        count++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
