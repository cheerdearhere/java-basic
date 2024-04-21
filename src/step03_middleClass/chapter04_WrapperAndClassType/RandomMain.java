package step03_middleClass.chapter04_WrapperAndClassType;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random();
        //정수 범위 내 랜덤
        int randomInt = random.nextInt();
        System.out.println("randomInt = " + randomInt);
        //0~1 사이 랜덤
        double randomDouble = random.nextDouble();
        System.out.println("randomDouble = " + randomDouble);
        // true or false
        boolean randomBoolean = random.nextBoolean();
        System.out.println("randomBoolean = " + randomBoolean);

        // 범위로 조회
        int range9 = random.nextInt(10);// 0~9
        System.out.println("range9 = " + range9);
        int range10 = random.nextInt(10)+1;// 1~10
        System.out.println("range10 = " + range10);

        // seed를 지정해 일정 값을 얻을 수 있음
        Random seedRandom = new Random(1);
            //개별 수행은 다른 값을 갖지만 개별 결과의 값은 일정함(내부 연산을 동일하게 진행)
        int seed1 = seedRandom.nextInt(10);
        int seed2 = seedRandom.nextInt(10);
        System.out.println("seed: " + seed1 + " " + seed2);

    }
}
