package step04_middleClass2.chapter02_CollectionFramework.linkedList;

public class NodeMain {
    public static void main(String[] args) {
        // A -> B -> C
        Node first = new Node("A");
        first.setNext(new Node("B"));
        first.getNext().setNext(new Node("C"));
        System.out.println("First Node: " + first.getItem());
        System.out.println("Second Node: " + first.getNext().getItem());
        System.out.println("Third Node: " + first.getNext().getNext().getItem());

        //모든 노드 순회
        System.out.println("## iterate all node");
        Node currentReference = first;
        int count = 0;
        while (currentReference != null) {
            System.out.println((++count)+". " + currentReference.getItem());
            currentReference = currentReference.getNext();
        }

        System.out.println(first);
        System.out.println(first.getNext());
        
        //모든 노드 탐색하기
        System.out.println("find Data - B : "+indexOf(first, "B"));
        System.out.println("find Data - notFound : "+indexOf(first, "notFound"));
        //마지막 노드 찾기
        Node lastNode = getLastNode(first);
        System.out.println("lastNode: " + lastNode.getItem());
        //index로 노드 찾기
        Node index2Node = findNodeByIdx(first, 2);
        System.out.println("index 2 Node: " + index2Node.getItem());
        Node index10Node = findNodeByIdx(first, 10);
        System.out.println("index 10 Node: " + index10Node.getItem());
        //노드 리스트에 데이터 추가하기
        addNode(first, "D");
        addNode(first, "E");
        addNode(first, "F");
    }

    private static void addNode(Node n, Object o) {
        while (n.getNext() != null) {
            n = n.getNext();
        }
        n.setNext(new Node(o));
        System.out.println("add "+o+": "+n);
    }

    private static Node findNodeByIdx(Node n, int idx) {
        for (int i = 0; i < idx; i++) {
            if(n.getNext()==null) {
                System.out.println("index " + i + "가 마지막입니다. 요청한 index: " + idx);
                return n;
            }
            n=n.getNext();
        }
        return n;
    }

    private static Node getLastNode(Node targetNode) {
        while (targetNode.getNext() != null) {
            targetNode = targetNode.getNext();
        }
        return targetNode;
    }

    private static int indexOf(Node n, Object o) {
        int i = 0;
        while (n != null) {
            if(o.equals(n.getItem()))
                return i;
            i++;
            n = n.getNext();
        }
        return -1;
    }
}
