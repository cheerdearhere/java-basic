package step04_middleClass2.chapter02_CollectionFramework.utils.comparator;

public class MyUser implements Comparable<MyUser> {
    private String id;
    private int age;
    public MyUser(String id, int age) {
        this.id = id;
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(MyUser o) {
        return (age-o.age==0)
                ?this.id.compareTo(o.id)
                :age-o.age;
    }
}
