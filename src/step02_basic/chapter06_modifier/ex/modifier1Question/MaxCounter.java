package step02_basic.chapter06_modifier.ex.modifier1Question;

import java.util.Scanner;

public class MaxCounter {
    private int count;
    private int max;
//    constructor
    public MaxCounter(int start,int max){
        count = start;
        this.max = max;
    }
    public MaxCounter(int max){
        this(0,max);
    }
//    public methods
    public void increment(){
        if(count>=max){
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        count++;
    }
    public int getCount(){
        return count;
    }
}
