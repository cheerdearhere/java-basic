package step03_middleClass.chapter05_Enum.test.exam01;

/*
문제1-1 - 인증 등급 만들기
문제 설명
패키지의 위치는 enumeration.test 를 사용하자.
회원의 인증 등급을 AuthGrade 라는 이름의 열거형으로 만들어라.
인증 등급은 다음 3가지이고, 인증 등급에 따른 레벨과 설명을 가진다. 레벨과 설명을 getXxx() 메서드로 조회할 수
있어야 한다.
    GUEST(손님)
        level=1
        description=손님
    LOGIN(로그인 회원)
        level=2
        description=로그인 회원
    ADMIN(관리자)
        level=3
        description=관리자

문제1-2 - 인증 등급 열거형 조회하기
문제 설명
AuthGradeMain1 이라는 클래스를 만들고 다음 결과가 출력되도록 코드를 작성해라.
앞서 만든 AuthGrade 을 활용하자
grade=GUEST, level=1, 설명=손님
grade=LOGIN, level=2, 설명=로그인 회원
grade=ADMIN, level=3, 설명=관리자

문제1-3 - 인증 등급 열거형 활용하기
문제 설명
AuthGradeMain2 클래스에 코드를 작성하자.
인증 등급을 입력 받아서 앞서 만든 AuthGrade 열거형으로 변환하자.
인증 등급에 따라 접근할 수 있는 화면이 다르다.
예를 들어 GUEST 등급은 메인 화면만 접근할 수 있고, ADMIN 등급은 모든 화면에 접근할 수 있다.
각각의 등급에 따라서 출력되는 메뉴 목록이 달라진다.
다음 출력 결과를 참고해서 코드를 완성하자.
GUEST 입력 예
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: GUEST
    당신의 등급은 손님입니다.
    ==메뉴 목록==
    - 메인 화면
LOGIN 입력 예
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: LOGIN
    당신의 등급은 로그인 회원입니다.
    ==메뉴 목록==
    - 메인 화면
    - 이메일 관리 화면
ADMIN 입력 예
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ADMIN
    당신의 등급은 관리자입니다.
    ==메뉴 목록==
    - 메인 화면
    - 이메일 관리 화면
    - 관리자 화면
잘못된 값이 입력되는 경우
    당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: x
    Exception in thread "main" java.lang.IllegalArgumentException: No enum constant
    enumeration.test.AuthGrade.X
    at java.base/java.lang.Enum.valueOf(Enum.java:293)
    at enumeration.test.AuthGrade.valueOf(AuthGrade.java:3)
    at enumeration.test.AuthGradeMain2.main(AuthGradeMain2.java:12)
    참고: Enum.valueOf() 를 사용할 때 잘못된 값이 입력되면 예와 같이 IllegalArgumentException 예외가 발
    생한다. 해당 예외를 잡아서 복구하는 방법은 예외 처리에서 학습한다.
 */
public class AuthGradeMain1 {
    public static void main(String[] args) {
        for(AuthGrade authGrade : AuthGrade.values()){
            printAuthInfo(authGrade);
        }
    }
    private static void printAuthInfo(AuthGrade authGrade){
        System.out.println("grade=" + authGrade.name() + ", level=" + authGrade.getLevel() + ", 설명=" + authGrade.getDescription());
    }
}
