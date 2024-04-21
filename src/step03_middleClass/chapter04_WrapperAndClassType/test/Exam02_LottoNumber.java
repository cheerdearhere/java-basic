package step03_middleClass.chapter04_WrapperAndClassType.test;

import java.util.*;
import java.util.stream.Stream;

/*
문제 - 로또 번호 자동 생성기
문제 설명
로또 번호를 자동으로 만들어주는 자동 생성기를 만들자
로또 번호는 1~45 사이의 숫자를 6개 뽑아야 한다.
각 숫자는 중복되면 안된다.
실행할 때 마다 결과가 달라야 한다.
실행 결과
로또 번호: 11 19 21 35 29 16
 */
public class Exam02_LottoNumber {
    public static void main(String[] args) {
//        lotto number maker in lecture by myself
        customGetLottoNumber();
    }

    /**
     * my lotto number maker
     */
    private static void customGetLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        int num = 0;
        while (lottoNumbers.size() < 7) {
            num = (int) (Math.random() * 10) + 1;
            if(!lottoNumbers.contains(num)){
                lottoNumbers.add(num);
            }
            else{
                System.out.println("duplicate number");
            }
        }
        System.out.print("로또 번호: ");
        Stream.of(lottoNumbers).forEach(lotto->{
            System.out.print(lotto+"  ");
        });
        System.out.println();
    }



}
