package step01_beginner.chapter04_loop;

public class Loop5 {
    public static void main(String[] args) {
//        구구단 출력하기
        for(int i=1;i<=9;i++){
            System.out.println(i+"단");
            for(int j=1;j<=9;j++){
                System.out.println(i+" x "+j+" = "+(i*j));
            }
        }
    }
}
