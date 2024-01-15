package chapter03_condition.ex;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Condition2Question {
    /*
    문제2. 거리에 따른 운송수단 선택
        1Km 이하 > 도보
        10Km 이하 > 자전거
        100km 이하 > 자동차
        그 이상 > 비행기
        거리는 변수 distance로 지정하고 운송수단을 출력
        ...를 이용하세요.
     */
    public static void main(String[] args) {
        Random r = new Random();
        int distance = r.nextInt(0,2*100*1000);
        String mov;
        int kmDistance = distance/1000;

        if(kmDistance<=10) mov = kmDistance <= 1 ? "도보" : "자전거";
        else if(kmDistance<=100) mov = "자동차";
        else mov = "비행기";

        System.out.println(
                "이동거리: "+distance+"m("+kmDistance+"Km) \n 안내: "+mov+"를 이용하세요.");
    }
}
