package step04_middleClass2.chapter02_CollectionFramework.set.objectHash;

import java.util.Objects;

/**
 * hash 사용을 위한 테스트 class
 */
public class Member {
    private String id;

    public Member(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Member member)) return false;
//        return Objects.equals(id, member.id);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Member id: " + id;
    }
}
