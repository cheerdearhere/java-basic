package step04_middleClass2.chapter02_CollectionFramework.list;

public interface MyList <E>{
    int size();
    void add(E e);
    void add(int index, E e);
    E get(int index);
    E set(int index, E e);
    E remove(int index);
    int indexOf(E e);
    @Override
    String toString();
}
