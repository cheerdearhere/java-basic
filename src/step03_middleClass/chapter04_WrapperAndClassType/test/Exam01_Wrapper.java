package step03_middleClass.chapter04_WrapperAndClassType.test;


import java.util.Arrays;

public class Exam01_Wrapper {
    public static void main(String[] args) {
/*
문제1 - parseInt()
문제 설명
문자로 입력된 str1 , str2 두 수의 합을 구하자.

package lang.wrapper.test;
public class WrapperTest1 {
 public static void main(String[] args) {
 String str1 = "10";
 String str2 = "20";
 // 코드 작성
 }
}

실행 결과
두 수의 합: 30
 */
        String str1 = "10";
        String str2 = "20";
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        System.out.println("두 수의 합: "+(num1+num2));
/*
문제2 - parseDouble()
문제 설명
배열에 입력된 모든 숫자의 합을 구하자. 숫자는 double 형이 입력될 수 있다.

package lang.wrapper.test;
public class WrapperTest2 {
 public static void main(String[] args) {
 String[] array = {"1.5", "2.5", "3.0"};
 // 코드 작성
 }
}

실행 결과
sum = 7.0
 */
        String[] array = {"1.5", "2.5", "3.0"};
        double sum = Arrays.stream(array).mapToDouble(Double::parseDouble).sum();
        System.out.println("sum: "+sum);
/*
문제3 - 박싱, 언박싱
문제 설명
String str 을 Integer 로 변환해서 출력해라.
Integer 를 int 로 변환해서 출력해라.
int 를 Integer 로 변환해서 출력해라.
오토 박싱, 오토 언박싱을 사용하지 말고 직접 변환해야 한다.

package lang.wrapper.test;
public class WrapperTest3 {
 public static void main(String[] args) {
 String str = "100";
 // 코드 작성
 }
}

실행 결과
integer1 = 100
intValue = 100
integer2 = 100
 */
        String str = "100";
        Integer integerStr = Integer.valueOf(str);
        System.out.println("integerStr = " + integerStr);
        int intStr = integerStr.intValue();
        System.out.println("intStr = " + intStr);
        Integer boxingInt = Integer.valueOf(intStr);
        System.out.println("boxingInt = " + boxingInt);
/*
문제4 - 오토 박싱, 오토 언박싱
문제 설명
String str 을 Integer 로 변환해서 출력해라.
Integer 를 int 로 변환해서 출력해라.
int 를 Integer 로 변환해서 출력해라.
오토 박싱, 오토 언박싱을 사용해서 변환해야 한다.
```java
package lang.wrapper.test;
public class WrapperTest4 {
 public static void main(String[] args) {
 String str = "100";
 // 코드 작성
 }
}
```
실행 결과 ```
integer1 = 100
intValue = 100
integer2 = 100
 */
        String str02 = "100";
        Integer autoInteger1 = Integer.valueOf(str02);
        System.out.println("autoInteger1 = " + autoInteger1);
        int autoInt = autoInteger1;
        System.out.println("autoInt = " + autoInt);
        Integer autoBoxing = autoInt;
        System.out.println("autoBoxing = " + autoBoxing);
    }
}
