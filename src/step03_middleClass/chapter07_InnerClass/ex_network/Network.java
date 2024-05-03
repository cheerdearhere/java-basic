package step03_middleClass.chapter07_InnerClass.ex_network;

public class Network {
    public void sendMessage(String text){
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }
}
