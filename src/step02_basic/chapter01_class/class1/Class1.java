package step02_basic.chapter01_class.class1;

public class Class1 {
    public static void main(String[] args) {
        Student student1; // 클래스의 객체 선언
        student1 = new Student(); // 클래스의 객체 생성
        student1.name = "학생1"; //객체의 멤버 변수 입력
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade =80;

        //멤버 변수는 해당 객체.변수명으로 값을 찾아서 사용
        System.out.println("이름:"+student1.name+"나이:"+student1.age+"성적:"+student1.grade);
        //객체를 사용하면 해당 객체의 소속(package.package...Class주소@참조값)
        System.out.println(student2);
    }

}
