package step04_middleClass2.chapter02_CollectionFramework.list;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("=추가=");
        System.out.println("== ArrayList==");
        addFirst(new ArrayList<>(),size); //검색: O(1), 추가(밀기): O(n)
        addMiddle(new ArrayList<>(),size); //검색: O(1), 추가(밀기): O(n/2)
        ArrayList<Integer> arrayList = new  ArrayList<>();//검색용 데이터
        addLast(arrayList,size); //검색: O(1), 추가(밀기): O(1)
        System.out.println("== LinkedList==");
        addFirst(new LinkedList<>(),size);//검색: O(1), 추가(밀기): O(1)
        addMiddle(new  LinkedList<>(),size); //검색: O(n), 추가(밀기): O(1)
        LinkedList<Integer> linkedList = new  LinkedList<>();//검색용 데이터
        addLast(linkedList,size); //검색: O(n), 추가(밀기): O(1)

        System.out.println("=조회=");
        int loop = 10000;
        System.out.println("== ArrayList==");
        getIndex(arrayList,loop,0);
        getIndex(arrayList,loop,size/2);
        getIndex(arrayList,loop,size-1);
        System.out.println("== LinkedList==");
        getIndex(linkedList,loop,0);
        getIndex(linkedList,loop,size/2);
        getIndex(linkedList,loop,size-1);

        System.out.println("=검색=");
        System.out.println("== ArrayList==");
        searchData(arrayList,loop,0);
        searchData(arrayList,loop,size/2);
        searchData(arrayList,loop,size-1);
        System.out.println("== LinkedList==");
        searchData(linkedList,loop,0);
        searchData(linkedList,loop,size/2);
        searchData(linkedList,loop,size-1);
    }
    private static void searchData(List<Integer> list, int loop, int searchKey ){
        long start = System.currentTimeMillis();
        for(int i=0;i<loop;i++){
            list.indexOf(searchKey);
        }
        long end = System.currentTimeMillis();
        System.out.println("find data: \n\tsearch key word: " + searchKey + "\tloop: " + loop + "\t\ttime: " + (end - start) + "ms");
    }
    private static void getIndex(List<Integer> list, int loop, int index){
        long start = System.currentTimeMillis();
        for(int i = 0; i < loop; i++){
            list.get(index);
        }
        long end = System.currentTimeMillis();
        System.out.println("get by index: \n\tindex: " + (index==0?"00000":index) + "\tloop: " + loop + "\t\ttime: " + (end - start) + "ms");
    }

    private static void addFirst(List<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insert to front: \n\tsize: " + size + " time: " + (end - start) + "ms");
    }
    private static void addMiddle(List<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(i/2, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insert to medium: \n\tsize: " + size + " time: " + (end - start) + "ms");
    }
    private static void addLast(List<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(i, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insert to last: \n\tsize: " + size + " time: " + (end - start) + "ms");
    }
}
