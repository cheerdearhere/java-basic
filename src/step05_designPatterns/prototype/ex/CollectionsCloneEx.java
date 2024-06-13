package step05_designPatterns.prototype.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsCloneEx {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("hong"));
        students.add(new Student("kim"));
        students.add(new Student("kang"));

        students.forEach(System.out::println);
        //1. ArrayList clone
        ArrayList<Student> studentsCopy1 = (ArrayList<Student>) students.clone();
        //2. 생성자 사용하기
        ArrayList<Student> studentsCopy2 = new ArrayList<>(students);

    }
}
