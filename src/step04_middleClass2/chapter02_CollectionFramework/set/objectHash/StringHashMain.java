package step04_middleClass2.chapter02_CollectionFramework.set.objectHash;

public class StringHashMain {
    private static final int CAPACITY = 10;
    public static void main(String[] args) {
        //char
        char charA = 'A';
        char charB = 'B';

        System.out.println("charA = " + charA);
        System.out.println("charA code = " + (int) charA);
        System.out.println("charB code = " + (int) charB);

        System.out.println("hash(charA) = " + hash(charA));
        System.out.println("charA hash index: "+hashIndex(charA));
        System.out.println("hashCode(\"AB\") = " + hashCode("AB"));
        System.out.println("AB hash index: "+hashIndex("AB"));
    }
    private static int hash(char ch) {
        return (int) ch;
    }
    private static int hashCode(String str) {
        int hash = 0;
        char[] chars = str.toCharArray();
        for(char ch : chars) {
            hash += (int) ch;
        }
        return hash;
//        System.out.println(Arrays.toString(str.toCharArray()));
//        System.out.println(Arrays.toString(str.chars()
//                .map(Character::getNumericValue).toArray()));
//        return str.chars()
//                .map(Character::getNumericValue)
//                .sum();
    }
    private static int hashIndex(char value){
        int hash = hash(value);
        return hash % CAPACITY;
    }
    private static int hashIndex(String str){
        int hash = hashCode(str);
        return hash % CAPACITY;
    }
}
