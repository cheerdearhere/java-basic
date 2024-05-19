package step04_middleClass2.chapter02_CollectionFramework.linkedList;

public class Node {
    private Object item;
    private Node next;

    public Node(Object item) {
        this.item = item;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Object getItem() {
        return item;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node current = this;
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
