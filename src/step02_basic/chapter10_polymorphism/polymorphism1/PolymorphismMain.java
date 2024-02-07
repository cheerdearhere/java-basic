package step02_basic.chapter10_polymorphism.polymorphism1;

public class PolymorphismMain {
    public static void main(String[] args) {
//        부모 타입 변수가 부모 인스턴스 참조
        System.out.println("Parent > Parent");
        Parent parent = new Parent();
        parent.parentMethod();
//        자식 타입 변수가 부모, 자식 인스턴스 참조
        System.out.println("Child > Child");
        Child child = new Child();
        child.childMethod();
        child.parentMethod();
//        부모 타입 변수가 자식 인스턴스 참조 (다형적 참조)
        System.out.println("Parent > Child");
        Parent poly = new Child();
        //자녀의 자녀 인스턴스도 가능
        Parent polyPoly = new Grandson();

        poly.parentMethod();
      //poly.childMethod();//자식의 기능은 사용 못함
//       부모 타입 변수가 자식 인스턴스의 것을 사용하기 위해서는 명시적 형변환(down casting)
        Child useChild = (Child)poly;
        useChild.childMethod();
        //일시적 다운캐스팅으로 간결하게 사용할 수 있다.
        ((Grandson) poly).grandsonMethod();
    }
}
