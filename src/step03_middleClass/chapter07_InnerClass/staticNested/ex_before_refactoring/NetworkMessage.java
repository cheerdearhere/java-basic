package step03_middleClass.chapter07_InnerClass.staticNested.ex_before_refactoring;

public class NetworkMessage {
    //network only
    private String message;
    public NetworkMessage(String content){
        this.message = content;
    }
    public void print(){
        System.out.println("network message: "+message);
    }
}
