package step04_middleClass2.chapter02_CollectionFramework.linkedList;

public class MyLinkedListMain {
    public static void main(String[] args) {
//        MyLinkedListV0 list = new MyLinkedListV0();
//        MyLinkedListV1 list = new MyLinkedListV1();
        MyLinkedListV2<String> list = new MyLinkedListV2<>();
        System.out.println("-- add data --");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list);

        System.out.println("myArrayList.size() = " + list.size());
        System.out.println("myArrayList.get(1) = " + list.get(1));
        System.out.println("myArrayList.indexOf(\"d\") = " + list.indexOf("d"));
        System.out.println("myArrayList.indexOf(\"no data\") = " + list.indexOf("nodata"));
        System.out.println("myArrayList.set(2,\"Z\") = " + list.set(2, "Z"));
        System.out.println(list);

        // index로 데이터 추가, 제거
        list.set(list.size() - 1, "F");
        System.out.println(list);
        list.set(0, "H");
        System.out.println(list);

        // index로 데이터 추가, 제거
        list.add(list.size() - 1, "G");
        System.out.println(list);
        list.add(0, "I");
        System.out.println(list);
        System.out.println("remove(last idx = " + (list.size() - 1) + "): " + list.remove(list.size() - 1));
        System.out.println(list);
        int removeTargetIdx = (list.size() / 2);
        System.out.println("remove(middle idx = " + removeTargetIdx + "): " + list.remove(removeTargetIdx));
        System.out.println(list);

//        타입 안정성 확인
        MyLinkedListV1 intList = new MyLinkedListV1();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add("4");
        int idx1 = (Integer) intList.get(1);
        int idx2 = (Integer) intList.get(2);
//        int idx3 = (Integer) intList.get(3);//Type cast error

        MyLinkedListV2<Integer> intGenericList = new MyLinkedListV2<>();
        intGenericList.add(1);
        intGenericList.add(2);
        intGenericList.add(3);
//        intGenericList.add("4");
        int g1 = intGenericList.get(1);
        int g2 = intGenericList.get(2);
//        int g3 = intGenericList.get(3);
    }
}
