package step02_basic.chapter06_modifier.modifier1.a;

public class AccessData {
    public String publicField = "public";
    String defaultField = "default";
    private String privateField = "private";

    public void publicMethod(){
        System.out.println(publicField);
    }
    void defaultMethod(){
        System.out.println(defaultField);
    }
    private void privateMethod(){
        System.out.println(privateField);
    }

    public void innerAccess(){
        String innerMessage = "\n   class 내부 접근 완료";
        publicField+=innerMessage;
        defaultField+=innerMessage;
        privateField+=innerMessage;

        publicMethod();
        defaultMethod();
        privateMethod();
    }

}
