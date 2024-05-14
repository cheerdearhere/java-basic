package step04_middleClass2.chapter01_Generic.animal;

public class Animal {
    // member
    private String name;
    private int size;
    // constructor
//    public Animal() {}
    public Animal(String name, int size){
        this.name = name;
        this.size = size;
    }
    //getter, setter
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    // abstract methods
    public void sound(){
        System.out.println("select animal");
    };
    // overriding
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
