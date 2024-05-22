package step04_middleClass2.chapter02_CollectionFramework.list;


public class BatchProcessorMain {
    public static void main(String[] args) {
        int dataSize = 1_00_000;
        MyArrayList<Integer> list = new MyArrayList<>();
        BatchProcessor processor = new BatchProcessor(list);
        processor.insertFront(dataSize);
        processor.insertTail(dataSize);
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        BatchProcessor processor2 = new BatchProcessor(list2);
        processor2.insertFront(dataSize);
        processor2.insertTail(dataSize);

    }
}
