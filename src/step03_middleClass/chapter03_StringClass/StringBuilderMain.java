package step03_middleClass.chapter03_StringClass;

public class StringBuilderMain {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println("sb = " + sb);

        sb.insert(3, "Java");
        System.out.println("sb = " + sb);

        sb.delete(3, 7);
        System.out.println("sb = " + sb);
        
        sb.reverse();
        System.out.println("sb = " + sb);

        sb.repeat(sb,3);
        System.out.println("sb = " + sb);

        String immutableCharacterSequence = sb.toString();
        System.out.println("immutableCharacterSequence = " + immutableCharacterSequence);

//      체크용 시간 측정
        int count = 100000;

        long startTime = System.currentTimeMillis();
        String res = "";
        for(int i=0; i<count; i++) {
            res += "Hello World!";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("duration using + operator: "+(endTime-startTime)+" ms");

        startTime = System.currentTimeMillis();
        String res2="";
        for(int i=0; i<count; i++) {
            res2 = new StringBuilder().append("Hello World!").toString();
        }
        endTime=System.currentTimeMillis();
        System.out.println("duration using mutable CharSequence: "+(endTime-startTime)+" ms");
    }
}
