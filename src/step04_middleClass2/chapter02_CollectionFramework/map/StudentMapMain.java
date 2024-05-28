package step04_middleClass2.chapter02_CollectionFramework.map;

import java.util.HashMap;
import java.util.Map;

public class StudentMapMain {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        studentMap.put("studentA", 50);
        System.out.println(studentMap);
        //학생이 없는 경우에만 추가
        String studentName = "studentA";
        addUnique(studentMap, studentName, 10);
        studentName = "studentB";
        addUnique(studentMap, studentName, 70);


    }
    private static void addUnique(Map<String, Integer> studentMap, String studentName, int score) {
        if(studentMap.containsKey(studentName)) {
            System.out.println("이미 입력된 값입니다: "+studentName);
        }else {
            studentMap.put(studentName, score);
            System.out.println(studentMap);
        }
    }
}
