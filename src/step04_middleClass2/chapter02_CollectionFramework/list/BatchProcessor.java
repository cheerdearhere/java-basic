package step04_middleClass2.chapter02_CollectionFramework.list;

public class BatchProcessor {
    private final MyList<Integer> list;
    public BatchProcessor(MyList<Integer> list) {
        this.list = list;
    }
    public void insertFront(int size){
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(0,i);// 앞에 추가
        }
        long end = System.currentTimeMillis();
        System.out.println("### 앞 추가 - 연산 종료: "+
                "\n\t size: "+ size +
                "\n\t duration: " + (end - start) + "ms"
        );
    }
    public void insertTail(int size){
        long start = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            list.add(i,i);// 앞에 추가
        }
        long end = System.currentTimeMillis();
        System.out.println("### 뒤에 추가 - 연산 종료: "+
                "\n\t size: "+ size +
                "\n\t duration: " + (end - start) + "ms"
        );
    }
}
