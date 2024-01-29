package step02_basic.chapter02_variable;

public class Variable1 {
    public static void main(String[] args) {
//      값 변경
        //primary type
        int a = 0;
        int b = a;
        printValue(a,b);
        a = 10;
        printValue(a,b);
        b = 30;
        printValue(a,b);
        //reference type
        int[] aArr = {1,2,3};
        int[] bArr = aArr;
        printRefAddr(aArr,bArr);
        printValue(aArr,bArr,0);
        aArr[0]=10;
        printRefAddr(aArr,bArr);
        printValue(aArr,bArr,0);
        bArr[2]=30;
        printRefAddr(aArr,bArr);
        printValue(aArr,bArr,2);

//      method 사용
        //primary type
        System.out.println("호출 전 a: "+a);
        changeValue(a);
        System.out.println("호출 후 a: "+a);
        //reference type
        int i = 1;
        System.out.println("호출 전 aArr[1]: "+aArr[i]);
        changeValue(aArr,i);
        System.out.println("호출 후 aArr[1]: "+aArr[i]);
    }

    private static void printValue(int a, int b){
        System.out.print("##print value>> ");
        System.out.println("a: "+a+"    b: "+b);
    }
    private static void printValue(int[] a, int[] b, int index){
        System.out.print("##print value>> ");
        System.out.println("a: "+a[index]+"    b: "+b[index]);
    }

    private static void printRefAddr(int[] a, int[] b){
        System.out.print("##print ref>> ");
        System.out.println("aArr ref: "+a+"    b ref: "+b);
    }

    private static void changeValue(int x){
        x=30;
    }
    private static void changeValue(int[] x,int i){
        x[i]=30;
    }

}
