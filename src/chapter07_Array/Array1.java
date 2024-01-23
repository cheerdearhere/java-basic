package chapter07_Array;

public class Array1 {
    public static void main(String[] args) {
//        같은 유형의 변수 여러개를 사용할 경우
        int student1 = 90;
        int student2 = 80;
        int student3 = 70;
        int student4 = 60;
        int student5 = 50;

        System.out.println("학생1: "+student1);
        System.out.println("학생2: "+student2);
        System.out.println("학생3: "+student3);
        System.out.println("학생4: "+student4);
        System.out.println("학생5: "+student5);
//        크기가 정해져있는 배열 선언하기
        int[] students = new int[5];
        students[0] = 90;
        students[1] = 80;
        students[2] = 70;
        students[3] = 60;
        students[4] = 50;

        System.out.println("학생1> "+students[0]);
        System.out.println("학생2> "+students[1]);
        System.out.println("학생3> "+students[2]);
        System.out.println("학생4> "+students[3]);
        System.out.println("학생5> "+students[4]);

        System.out.println(students);//메모리주소: [I@5b6f7412 여기에 배열이 순차적으로 보관됨
//        선언과 함께 초기화
        char[] grade = new char[]{'A','B','C'};
//        생략할 수 있지만 이때는 선언과 생성을 분리할 수 없음
        int[] intArr =/*new int[]*/{1,2,3,4};
        /* 이건 불가
            int[] intArr;
            intArr={};
         */
//        반복문을 사용해 값 넣고 빼기
        for(int i = students.length-1;i>0;i--){
            students[i] = 100-(i*3);
        }
        for(int i = 0;i<students.length;i++){
            System.out.println("학생"+(i+1)+">> "+students[i]);
        }
    }
}
