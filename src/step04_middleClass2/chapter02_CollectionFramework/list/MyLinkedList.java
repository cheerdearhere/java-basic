package step04_middleClass2.chapter02_CollectionFramework.list;

public class MyLinkedList<E> implements MyList<E> {
//    members
    private Node<E> first;
    private int size = 0;
//    public methods
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if(first == null) {
            first = newNode;
        }else {
            Node<E> lastNode = getLastNode();
            lastNode.setNext(newNode);
        }
        size++;
    }
    public void add(int index, E data) {
        Node<E> newNode = new Node<>(data);
        if(index == 0) {
            newNode.setNext(first);
            first = newNode;
        }
        else{
            Node<E> prevNode = getNode(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.getItem();
    }
    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.getItem();
        x.setItem(element);
        return oldValue;
    }
    public E remove(int index) {
        Node<E> removedNode = getNode(index);
        E removedItem = removedNode.getItem();
        //연결 재정의
        if(index == 0) {
            first = removedNode.getNext();
        }
        else {
            Node<E> prevNode = getNode(index - 1);
            prevNode.setNext(removedNode.getNext());
        }
        //값 비우기
        removedNode.setNext(null);
        removedNode.setItem(null);
        //기타 처리
        size--;
        return removedItem;
    }
    public int indexOf(E element) {
        int index = 0;
        for(Node<E> x = first; x != null; x = x.getNext()) {
            if(element.equals(x.getItem())) {
                return index;
            }
            index++;
        }
        return -1;
    }
    public int size() {
        return size;
    }
//    Override from Object
    @SuppressWarnings("DuplicatedCode")
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("myLinkedList: [");
        Node<E> x = first;
        while(x != null) {
            str.append(x.getItem());
            if(x.getNext() != null) {
                str.append(" -> ");
            }
            x = x.getNext();
        }
        str.append("]");
        return str.toString();
    }
//    private methods
    private Node<E> getLastNode() {
        Node<E> x = first;
        while(x.getNext() != null) {
            x = x.getNext();
        }
        return x;
    }
    private Node<E> getNode(int index) {
        Node<E> x = first;
        for(int i = 0; i < index; i++) {
            x = x.getNext();
        }
        return x;
    }

//    static nested class
    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item) {
            this.item = item;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
        public E getItem() {
            return item;
        }
        public void setItem(E element) {
            this.item = element;
        }
        @Override
        @SuppressWarnings("DuplicatedCode")
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> current = this;
            sb.append("[");
            while (current != null) {
                sb.append(current.getItem());
                if(current.getNext() != null)
                    sb.append(" -> ");
                current = current.getNext();
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
