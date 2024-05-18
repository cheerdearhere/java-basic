package step04_middleClass2.chapter02_CollectionFramework.arrayList;

public class MyArrayListMain {
    public static void main(String[] args) {
//        MyArrayListV0 myArrayList = new MyArrayListV0();
//        MyArrayListV1 myArrayList = new MyArrayListV1();
//        MyArrayListV2 myArrayList = new MyArrayListV2();
        MyArrayListV3<String> myArrayList = new MyArrayListV3<>();

        myArrayList.add("A");
        System.out.println(myArrayList);
        myArrayList.add("B");
        System.out.println(myArrayList);
        myArrayList.add("C");
        System.out.println(myArrayList);

        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.get(1) = " + myArrayList.get(1));
        System.out.println("myArrayList.indexOf(\"C\") = " + myArrayList.indexOf("C"));
        System.out.println("myArrayList.indexOf(\"no data\") = " + myArrayList.indexOf("D"));
        System.out.println("myArrayList.set(2,\"Z\") = " + myArrayList.set(2, "Z"));
        System.out.println(myArrayList);

        //동적할당
        myArrayList.add("D");
        myArrayList.add("E");
        System.out.println(myArrayList);
        myArrayList.add("F");
        System.out.println(myArrayList);

        // index로 데이터 추가, 제거
        myArrayList.add(myArrayList.size()-1,"G");
        System.out.println(myArrayList);
        myArrayList.add(0,"H");
        System.out.println(myArrayList);
        System.out.println("remove(last element) = " + myArrayList.remove(myArrayList.size() - 1));
        System.out.println(myArrayList);
        int removeTargetIdx = (int)(myArrayList.size()/2);
        System.out.println("remove(middle element:"+removeTargetIdx+") = " + myArrayList.remove(removeTargetIdx));
        System.out.println(myArrayList);

        //타입안정성 보장이 안됨
        MyArrayListV2 integerArrayList = new MyArrayListV2();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add("4");
        int idx1 = (Integer) integerArrayList.get(1);
        int idx2 = (Integer) integerArrayList.get(2);
//        int idx3 = (Integer) integerArrayList.get(3);//Type cast error

        MyArrayListV3<Integer> genericList = new MyArrayListV3<>();
        genericList.add(1);
        genericList.add(2);
        genericList.add(3);
//        genericList.add("4");
        int g1 = genericList.get(1);
        int g2 = genericList.get(2);
//        int g3 = genericList.get(3);


    }
}
