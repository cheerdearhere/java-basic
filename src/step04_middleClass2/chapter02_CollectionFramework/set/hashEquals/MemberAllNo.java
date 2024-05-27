package step04_middleClass2.chapter02_CollectionFramework.set.hashEquals;

public class MemberAllNo {
    private String id;

    public MemberAllNo(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "No hashCode/ No equals - id: " + id;
    }
}
