package step02_basic.chapter04_constructor.constructor1;

public class MemberInit {
    String name;
    int age;
    int grade;

    /**
     * 모든 매개변수를 받는 생성자
     * @param name 이름
     * @param age 나이
     * @param grade 성적
     */
    public MemberInit(String name, int age, int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    /**
     * Overloading를 사용해 다양한 방식의 생성자를 만들 수 있다.
     * @param name 이름
     */
    public MemberInit(String name){
        this.name=name;
    }

    /**
     * this()를 사용해 중복 코드를 줄인다. 
     * @param name 이름
     * @param age 나이
     */
    public MemberInit(String name, int age){
        this(name, age, 60);
        //this()는 첫줄에서 호출
    }
    /**
     * 기본 생성자
     */
//    public MemberInit(){}
    public MemberInit(){
        // 기본 생성자라도 초기값을 입력하는 것이 좋음(null 방지)
        this("",0,60);
    }
}
