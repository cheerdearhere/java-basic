package step03_middleClass.chapter01_Object.objectClass02;

public class Cat {
    private String catName;
    private int age;
    private String sound;
    public Cat (String catName,int age){
        this.catName=catName;
        this.age=age;
        sound = "야옹";
    }

    public void sound(){
        System.out.println(sound);
    }

    @Override
    public String toString() {
        return "Override: Cat class" +
                "\n\tsound: "+sound+
                "\n\tcatName: "+catName+
                "\n\tage: "+age;
    }
}
