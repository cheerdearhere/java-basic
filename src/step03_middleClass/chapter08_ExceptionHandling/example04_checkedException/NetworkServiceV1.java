package step03_middleClass.chapter08_ExceptionHandling.example04_checkedException;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;


public class NetworkServiceV1 {
    public void sendMessage(String data) throws NetworkClientException {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);

        client.initError(data);
        client.connect();
        client.send(data);
        client.disconnect();
    }
}
