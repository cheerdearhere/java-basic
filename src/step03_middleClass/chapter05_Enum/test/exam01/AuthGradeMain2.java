package step03_middleClass.chapter05_Enum.test.exam01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;


        System.out.print("당신의 등급을 입력하세요["
            + Arrays.stream(AuthGrade.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "))
            +"]: ");
        input = sc.nextLine().toUpperCase();
        System.out.println();

        AuthGrade grade = AuthGrade.valueOf(input);
        System.out.println(grade);
        System.out.println(grade.getMenu());
    }
}
