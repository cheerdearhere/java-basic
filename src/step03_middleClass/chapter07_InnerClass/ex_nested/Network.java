package step03_middleClass.chapter07_InnerClass.ex_nested;

public class Network {
    public void sendMessage(String text){
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }
    private static class NetworkMessage{
        private final String content;
        public NetworkMessage(String content){
            this.content = content;
        }
        private void print(){
            System.out.println("network message: "+content);
        }
    }
}
