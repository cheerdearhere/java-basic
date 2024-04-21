package step03_middleClass.chapter04_WrapperAndClassType;

import java.util.*;
import java.util.stream.Stream;

public class SystemMain {
    public static void main(String[] args) {
        //현재 시간
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis   = " + currentTimeMillis);
        long currentTimeNanos = System.nanoTime();
        System.out.println("currentTimeNanos    = " + currentTimeNanos);
        //운영체제가 사용하는 시스템 환경변수
        Map<String,String> osEnv = System.getenv();
        System.out.println("map = " + osEnv);
        //자바가 사용하는 환경변수
        Properties javaProperties = System.getProperties();
        javaProperties.list(System.out);
        System.out.println("java version: "+javaProperties.getProperty("java.version"));
        // 배열 고속 복사
        char[] originalArray = {'h','e','l','l','o'};
        char[] newArray = new char[originalArray.length];
        //반복문이 아닌 객체 깊은 복사
        System.arraycopy(originalArray,0,newArray,0,originalArray.length);
        Stream.of(newArray).forEach(System.out::println);
        //프로그램 종료
        System.exit(0);
    }
}
