package step03_middleClass.chapter07_InnerClass.innerClass;

public class ShadowingInner {
    public int value = 1;
    class Inner {
        public int value = 2;
        void innerScope(){
            int value = 3;
            System.out.println("innerScope: value = "+value);
            System.out.println("inner.value: this.value = "+this.value);
            System.out.println("outer.value: OuterClass.this.value = "+ShadowingInner.this.value);
        }
    }
    public static void main(String[] args) {
        ShadowingInner shadowingInner = new ShadowingInner();
        Inner inner = shadowingInner.new Inner();
        inner.innerScope();
    }
}
