package step02_basic.chapter07_virtalMachine.ex.javaMemory2Question;

import java.util.Arrays;
import java.util.Objects;

public class MathArrayUtils {
    public static int sum(int[] array)    {
        int sum=0;
        if(Objects.isNull(array)){
            return 0;
        }
        for(int num:array){
            sum+=num;
        }
        return sum;
    }
    public static double average(int[] array){
        return (double) sum(array)/array.length;
    }
    public static int min(int[] array)    {
        if(Objects.isNull(array)){
            return 0;
        }
        int min=array[0];
        for(int num:array){
            if(min==num) continue;
            min = min>num?num:min;// Math.min(num,min);
        }
        return min;
    }
    public static int max(int[] array)    {
        return Arrays.stream(array).max().orElseThrow();
    }
}
