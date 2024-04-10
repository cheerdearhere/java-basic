package step03_middleClass.chatper02_Immutable.exam01_Immutable;

/*
문제 설명
MyDate 클래스는 불변이 아니어서 공유 참조시 사이드 이펙트가 발생한다. 이를 불변 클래스로 만들어라.
새로운 불변 클래스는 ImmuableMyDate 로 이름 지으면 된다.
새로운 실행 클래스는 ImmuableMyDateMain 으로 이름 지으면 된다.
 */
public class ImmutableMyDateMain {
    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2024,1,1);
        ImmutableMyDate date2 = date1;
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("2025 -> date1");
//        date1.setYear(2025);
        date1 = date1.resetDate(2025);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
    }
}
