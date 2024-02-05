package step02_basic.chapter09_extends.extends5.parent;

public class Parent {
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod(){
        System.out.println("Parent.public method");
    }
    protected void protectedMethod(){
        System.out.println("Parent.protected method");
    }
    void defaultMethod(){
        System.out.println("Parent.default method");
    }
    private void privateMethod(){
        System.out.println("Parent.private method ");
    }

    public void printParent(){
        System.out.println("====print in Parent====");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("defaultValue = " + defaultValue);
        System.out.println("privateValue = " + privateValue);

        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}
