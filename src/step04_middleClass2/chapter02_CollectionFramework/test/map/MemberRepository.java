package step04_middleClass2.chapter02_CollectionFramework.test.map;

import java.util.*;
import java.util.stream.Collectors;

/*
문제6 - 회원 관리 저장소
문제 설명
Map 을 사용해서 회원을 저장하고 관리하는 MemberRepository 코드를 완성하자.
Member , MemberRepositoryMain 코드와 실행 결과를 참고하자.

package collection.map.test.member;
public class Member {
 private String id;
 private String name;
 public Member(String id, String name) {
 this.id = id;
 this.name = name;
 }
 public String getId() {
 return id;
 }
 public String getName() {
 return name;
 }
 @Override
 public String toString() {
 return "Member{" +
 "id='" + id + '\'' +
 ", name='" + name + '\'' +
 '}';
 }
}

package collection.map.test.member;
public class MemberRepositoryMain {
 public static void main(String[] args) {
 Member member1 = new Member("id1", "회원1");
 Member member2 = new Member("id2", "회원2");
 Member member3 = new Member("id3", "회원3");
 // 회원 저장
 MemberRepository repository = new MemberRepository();
 repository.save(member1);
 repository.save(member2);
 repository.save(member3);
 // 회원 조회
 Member findMember1 = repository.findById("id1");
 System.out.println("findMember1 = " + findMember1);
 Member findMember3 = repository.findByName("회원3");
 System.out.println("findMember3 = " + findMember3);
 // 회원 삭제
 repository.remove("id1");
 Member removedMember1 = repository.findById("id1");
 System.out.println("removedMember1 = " + removedMember1);
 }
}

MemberRepository 코드 작성
package collection.map.test.member;
import java.util.HashMap;
import java.util.Map;
public class MemberRepository {
 private Map<String, Member> memberMap = new HashMap<>();
 public void save(Member member) {
 // 코드 작성
 }
 public void remove(String id) {
 // 코드 작성
 }
 public Member findById(String id) {
 // 코드 작성
 }
 public Member findByName(String name) {
 // 코드 작성
 }
}

실행 결과
findMember1 = Member{id='id1', name='회원1'}
findMember3 = Member{id='id3', name='회원3'}
removedMember1 = null
 */
public class MemberRepository {
    private Map<String, Member> memberMap = new HashMap<>();
    public void save(Member member) {
        memberMap.put(member.getId(), member);
    }
    public void remove(String id) {
        memberMap.remove(id);
    }
    public Member findById(String id) {
        return memberMap.get(id);
    }
    public Member findByName(String name) {
        //use for with values
//        Collection<Member> members = memberMap.values();
//        for(Member member : members) {
//            if(member.getName().equals(name)) {
//                return member;
//            }
//        }
//        return null;
        //stream, entrySet
//        return memberMap.entrySet()
//                .stream()
//                .filter(entry->name.equals(entry.getValue().getName()))
//                .map(Map.Entry::getValue)
//                .toList()
//                .getFirst();
        //stream, values
        return memberMap.values()
                .stream()
                .filter(member -> name.equals(member.getName()))
                .toList()
                .getFirst();
    }
}
