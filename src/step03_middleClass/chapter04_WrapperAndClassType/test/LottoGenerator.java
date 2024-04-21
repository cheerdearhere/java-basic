package step03_middleClass.chapter04_WrapperAndClassType.test;

import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {
    private final Random random=new Random();
    private int[] lottoNumbers;
    private int count;

    public LottoGenerator() {
        super();
    }
    public LottoGenerator(int seed) {
        random.setSeed(seed);
    }

    public int[] getLottoNumbers() {
        lottoNumbers = new int[6];
        count = 0;

        while (count < 6) {
            int number = random.nextInt(45) + 1;
            if(isUnique(number)) {
                lottoNumbers[count] = number;
                count++;
            }
        }
        return lottoNumbers;
    }
    private boolean isUnique(int number) {
        for(int i=0; i<count; i++) {
            if(number == lottoNumbers[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "로또 번호: ["+ Arrays.stream(lottoNumbers)
                .mapToObj(String::valueOf)
                .reduce((a,b)->a+", "+b)
                .orElse("error:: ")
                +"]";
    }
}
