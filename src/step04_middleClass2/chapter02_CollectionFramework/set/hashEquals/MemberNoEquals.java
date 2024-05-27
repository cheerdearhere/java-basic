package step04_middleClass2.chapter02_CollectionFramework.set.hashEquals;

import java.util.Objects;

public class MemberNoEquals {
    private String id;

    public MemberNoEquals(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return " No equals - id: " + id;
    }
}
