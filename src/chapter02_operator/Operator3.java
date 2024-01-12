package chapter02_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Operator3 {
    public static void main (String[] args){
//        증감연산자
        int a = 0;
        int b = 1;
        //일반 산술연산
        a = a+1;
        System.out.println("a = " + a);
        ++a;
        b++;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        for(int i=0;i<2;i++){
            System.out.println("inner a: " + ++a);// 처리 후 값이 올라감
            System.out.println("inner b: " + b++);// 처리 전 값이 올라감
        }
        System.out.println("outer a: " + a); // prefix, postfix 모두 결과는 같음
        System.out.println("outer b: " + b);
        --a;//1씩 감소
        b--;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
//        비교연산자
        a=2;
        b=3;
        boolean compareRes=true;
        //크기 비교
        compareRes = a==b;
        System.out.println("compareRes = " + compareRes);
        compareRes = a!=b;
        System.out.println("compareRes = " + compareRes);
        compareRes = a>b;
        System.out.println("compareRes = " + compareRes);
        compareRes = a<b;
        System.out.println("compareRes = " + compareRes);
        compareRes = a>=b;
        System.out.println("compareRes = " + compareRes);
        compareRes = a<=b;
        System.out.println("compareRes = " + compareRes);
        //char(Character)도 비교 가능
        char c1 = 'a';
        char c2 = 'b';
        compareRes = c1>c2;
        System.out.println("compareRes = " + compareRes);
        //문자열 비교는 .eauals() method를 사용
        String str1 = "java";
        String str2 = "javascript";
        compareRes = str1.equals(str2);
        System.out.println("compareRes = " + compareRes);
        // instanceof
        Operator1 op1 = new Operator1();
        System.out.println(op1 instanceof Operator1);
//        논리연산자
        //AND &&
        System.out.println(true&&true); //true
        System.out.println(true&&false); //false
        System.out.println(false&&false); //false
        //OR ||
        System.out.println(true||true); //true
        System.out.println(false||true); //true
        System.out.println(false||false); //false
        //NOT !
        System.out.println(true && !false); //true
        System.out.println(false || !false); //true
        System.out.println(true && !false); //true
        //사용 예시
        a= 15;
        if(a >= 15 && a < 18) System.out.println("a는 15와 18 사이의 값만");
//        대입연산자
        a = 3;
        System.out.println("a = " + a);
        a += 1;
        System.out.println("a+=1 >>> " + a);
        a -= 1;
        System.out.println("a-=1 >>> " + a);
        a *= 3;
        System.out.println("a*=3 >>> " + a);
        a /= 3;
        System.out.println("a/=3 >>> " + a);
        a %= 2;
        System.out.println("a%=2 >>> " + a);
    }
}
