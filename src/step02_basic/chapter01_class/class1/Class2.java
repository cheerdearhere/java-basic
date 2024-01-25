package step02_basic.chapter01_class.class1;

public class Class2 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade =80;

        Student student3 = new Student();
        student3.name = "학생3";
        student3.age = 14;
        student3.grade =70;

        Student[] studentArr = {student1,student2,student3,new Student()};

        studentArr[3].name = "학생4";
        studentArr[3].age = 17;
        studentArr[3].grade = 60;

        System.out.println("1번 학생: "+studentArr[0].name);
        for(int i=0;i<studentArr.length;i++){
            Student s = studentArr[i];
            System.out.print(" /이름만: "+s.name);
        }
        for(Student student : studentArr){
            System.out.println("이름:"+student.name+" /나이:"+student.age+" /성적:"+student.grade);
        }
    }

}
