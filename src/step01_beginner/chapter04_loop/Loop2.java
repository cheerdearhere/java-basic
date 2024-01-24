package step01_beginner.chapter04_loop;

public class Loop2 {
    public static void main(String[] args) {
        int i = 10;
        do{
            System.out.println("현재 숫자: " + i);
            i++;
        }while (i<3);//조건이 true일때 do 재수행
    }
}
