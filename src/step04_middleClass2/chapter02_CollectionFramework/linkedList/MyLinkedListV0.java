package step04_middleClass2.chapter02_CollectionFramework.linkedList;

public class MyLinkedListV0 {
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
