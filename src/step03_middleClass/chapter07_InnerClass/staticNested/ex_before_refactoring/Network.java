package step03_middleClass.chapter07_InnerClass.staticNested.ex_before_refactoring;

public class Network {
    public void sendMessage(String text){
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }
}
