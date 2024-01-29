package step02_basic.chapter02_variable.variable2;

public class Ref_Class2 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
//        student1.name = "학생1";
//        student1.age = 15;
//        student1.grade = 90;
        initStudent(student1,"학생1",15,90);

        Student student2 = new Student();
        initStudent(student2,"학생2",16,80);

        Student student3 = createStudent("학생3",17,70);
        Student student4 = createStudent("학생4",17,70);

        Student[] studentArr = {student1,student2,student3,student4,new Student()};
        initStudent(studentArr[4],"학생5",17,60);

        for(Student student : studentArr){
            printStudentInfo(student);
        }

        printAllName(studentArr);
    }

    private static void initStudent(Student student, String name, int age, int grade){
        student.name = name;
        student.age = age;
        student.grade = grade;
//      return을 사용하지 않아도 reference address로 보내기때문에 값이 변경된다.
    }

    private static Student createStudent(String name, int age, int grade) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student; //참조형 객체더라도 메모리 주소가 지정되지 않은 상태에서 새로만드는 것이므로 return 필요
    }

    private static void printStudentInfo(Student student){
        System.out.println("이름:"+student.name+" /나이:"+student.age+" /성적:"+student.grade);
    }
    private static void printAllName(Student[] students){
        System.out.print("이름만: ");
        int studentNum = students.length;
        for(int i=0;i<studentNum;i++){
            Student s = students[i];
            System.out.print(s.name);
            if(i!=studentNum-1){
                System.out.print(", ");
            }
            else{
                System.out.print("\n>> 총 "+studentNum+"명");
            }
        }

    }
}
