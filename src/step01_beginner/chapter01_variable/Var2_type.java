package step01_beginner.chapter01_variable;

public class Var2_type {
    public static void main(String[] args){
//        기본단위 8bit
        byte    b       = 125;            // -128 ~ 127
//        정수
        short   sh      = 32000;          // 2bytes : -32,768 ~ 32,767
        int     i       = 2100000000;     // 4bytes : -2,147,483,648 ~ 2,147,483,647
        long    l       = 1000000000200L; // 8bytes : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
//        실수: 부동소수점 사용(부호용 1자리+부동소수점)
        float   f       = 100.0F;         // 4bytes : 7자리 정밀도
        double  d       = 10.5;           // 8bytes : 15자리 정밀도
//        문자관련
        char    c       = 'A';            // 1byte  : 문자 하나
        String  str     = "String data";  //비정형(final로 선언된 문자 배열)
//        기타
        boolean bool    = true;           // 1byte  : true, false
        var     v       = 1;              // 비정형
    }
}
