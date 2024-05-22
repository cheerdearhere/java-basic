package step04_middleClass2.chapter02_CollectionFramework.test.list;


import java.util.*;

public class ArrayEx01 {
    public static void main(String[] args) {
        /*
        문제1 - 배열을 리스트로 변경하기
        문제 설명
        ArrayEx1 는 배열을 사용한다. 이 코드를 배열 대신에 리스트를 사용하도록 변경하자.
        다음 코드와 실행 결과를 참고해서 리스트를 사용하는 ListEx1 클래스를 만들어라.

        package collection.list.test.ex1;
        public class ArrayEx1 {
            public static void main(String[] args) {
            int[] students = {90, 80, 70, 60, 50};
            int total = 0;
            for (int i = 0; i < students.length; i++) {
            total += students[i];
            }
            double average = (double) total / students.length;
            System.out.println("점수 총합: " + total);
            System.out.println("점수 평균: " + average);
            }
        }

        실행 결과
            점수 총합: 350
            점수 평균: 70.0
         */
        System.out.println("문제1: 배열을 리스트로");
        int[] students = {90, 80, 70, 60, 50};
        List<Integer> studentList = new ArrayList<>();

//        for(int student : students){
//            studentList.add(student);
//        }
//        int total = 0;
//        for (int i = 0; i < studentList.size(); i++) {
//            total += studentList.get(i);
//        }
//        double average = (double) total / studentList.size();

        Arrays.stream(students).forEach(studentList::add);
        int total = studentList.stream().mapToInt(Integer::valueOf).sum();
        double average = (double) total / studentList.size();
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
