package step01_beginner.chapter03_condition.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Condition4Question {
    /*
    문제4. 평점에 따른 영화 추천하기
    요청한 평점 이상의 영화를 찾아서 추천하는 프로그램
        평점 9: 어바웃타임
        평점 8: 토이스토리
        평점 7: 고질라
        평점 6: 엄복동
    (영화이름)을 추천합니다.
     */
    public static void main(String[] args) {
        Random r = new Random();
        double rating = Math.floor(r.nextDouble(0.0,9.9));
        List<String> movieList = new ArrayList<>();
        if(rating<=9) movieList.add("어바웃타임");
        if(rating<=8) movieList.add("토이스토리");
        if(rating<=7) movieList.add("고질라");
        if(rating<=6) movieList.add("엄복동");
        System.out.println(
                "요청 평점: "+rating
                +"\n 추천 영화: " + String.join(", ", movieList)
        );
    }
}
