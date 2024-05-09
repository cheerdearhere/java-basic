package step03_middleClass.chapter08_ExceptionHandling.example01_firstModule;

public class NetworkService {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);

        client.connect();
        client.send(data);
        client.disconnect();
    }

}
