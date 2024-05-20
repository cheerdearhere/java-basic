package step04_middleClass2.chapter02_CollectionFramework.linkedList;

public class MyLinkedListV1 {
    private Node first;
    private int size = 0;

    public void add(Object data) {
        Node newNode = new Node(data);
        if(first == null) {
            first = newNode;
        }else {
            Node lastNode = getLastNode();
            lastNode.setNext(newNode);
        }
        size++;
    }
    public void add(int index, Object data) {
        Node newNode = new Node(data);
        if(index == 0) {
            newNode.setNext(first);
            first = newNode;
        }
        else{
            Node prevNode = getNode(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }
    public Object get(int index) {
        Node node = getNode(index);
        return node.getItem();
    }
    public Object set(int index, Object element) {
        Node x = getNode(index);
        Object oldValue = x.getItem();
        x.setItem(element);
        return oldValue;
    }
    public Object remove(int index) {
        Node removedNode = getNode(index);
        Object removedItem = removedNode.getItem();
        //연결 재정의
        if(index == 0) {
            first = removedNode.getNext();
        }
        else {
            Node prevNode = getNode(index - 1);
            prevNode.setNext(removedNode.getNext());
        }
        //값 비우기
        removedNode.setNext(null);
        removedNode.setItem(null);
        //기타 처리
        size--;
        return removedItem;
    }
    public int indexOf(Object o) {
        int index = 0;
        for(Node x = first; x != null; x = x.getNext()) {
            if(o.equals(x.getItem())) {
                return index;
            }
            index++;
        }
        return -1;
    }
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("myLinkedList: [");
        Node x = first;
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
    private Node getLastNode() {
        Node x = first;
        while(x.getNext() != null) {
            x = x.getNext();
        }
        return x;
    }
    private Node getNode(int index) {
        Node x = first;
        for(int i = 0; i < index; i++) {
            x = x.getNext();
        }
        return x;
    }
}
