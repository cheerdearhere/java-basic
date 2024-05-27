package step04_middleClass2.chapter02_CollectionFramework.set;

public interface MySet<E> {
    boolean add(E e);
    boolean remove(E e);
    boolean contains(E e);
    int getSize();
}
