package step04_middleClass2.chapter02_CollectionFramework.utils.iterator;

import java.util.Iterator;

public class MyArrayIterator implements Iterator<Integer> {
    private int currentIndex = -1;
    private int[] targetArr;

    public MyArrayIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < targetArr.length -1;// index 기준 마지막 항목
    }

    @Override
    public Integer next() {
        return targetArr[++currentIndex];//증가 시키고 해당 항목 전달
        //hasNext()로 체크하지 않으면 NullPointerException
    }
}
