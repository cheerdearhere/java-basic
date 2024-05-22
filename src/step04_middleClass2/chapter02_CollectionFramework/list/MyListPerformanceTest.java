package step04_middleClass2.chapter02_CollectionFramework.list;


public class MyListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("=추가=");
        System.out.println("==MyArrayList==");
        addFirst(new MyArrayList<>(),size); //검색: O(1), 추가(밀기): O(n)
        addMiddle(new MyArrayList<>(),size); //검색: O(1), 추가(밀기): O(n/2)
        MyArrayList<Integer> arrayList = new MyArrayList<>();//검색용 데이터
        addLast(arrayList,size); //검색: O(1), 추가(밀기): O(1)
        System.out.println("==MyLinkedList==");
        addFirst(new MyLinkedList<>(),size);//검색: O(1), 추가(밀기): O(1)
        addMiddle(new MyLinkedList<>(),size); //검색: O(n), 추가(밀기): O(1)
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();//검색용 데이터
        addLast(linkedList,size); //검색: O(n), 추가(밀기): O(1)

        System.out.println("=조회=");
        int loop = 10000;
        System.out.println("==MyArrayList==");
        getIndex(arrayList,loop,0);
        getIndex(arrayList,loop,size/2);
        getIndex(arrayList,loop,size-1);
        System.out.println("==MyLinkedList==");
        getIndex(linkedList,loop,0);
        getIndex(linkedList,loop,size/2);
        getIndex(linkedList,loop,size-1);

        System.out.println("=검색=");
        System.out.println("==MyArrayList==");
        searchData(arrayList,loop,0);
        searchData(arrayList,loop,size/2);
        searchData(arrayList,loop,size-1);
        System.out.println("==MyLinkedList==");
        searchData(linkedList,loop,0);
        searchData(linkedList,loop,size/2);
        searchData(linkedList,loop,size-1);
    }
    private static void searchData(MyList<Integer> list, int loop, int searchKey ){
        long start = System.currentTimeMillis();
        for(int i=0;i<loop;i++){
            list.indexOf(searchKey);
        }
        long end = System.currentTimeMillis();
        System.out.println("find data: \n\tsearch key word: " + searchKey + "\tloop: " + loop + "\t\ttime: " + (end - start) + "ms");
    }
    private static void getIndex(MyList<Integer> list, int loop, int index){
        long start = System.currentTimeMillis();
        for(int i = 0; i < loop; i++){
            list.get(index);
        }
        long end = System.currentTimeMillis();
        System.out.println("get by index: \n\tindex: " + (index==0?"00000":index) + "\tloop: " + loop + "\t\ttime: " + (end - start) + "ms");
    }

    private static void addFirst(MyList<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insert to front: size: " + size + " time: " + (end - start) + "ms");
    }
    private static void addMiddle(MyList<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(i/2, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insert to medium: size: " + size + " time: " + (end - start) + "ms");
    }
    private static void addLast(MyList<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(i, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("insert to last: size: " + size + " time: " + (end - start) + "ms");
    }
}
