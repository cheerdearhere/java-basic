package step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.AnotherNetworkException;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.ConnectException;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.NetworkClientException;
import step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception.SendException;

public class NetworkServiceV1 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);
        client.initError(data);
        try {
            client.connect();
            client.send(data);
        }
        finally {
            client.disconnect();
        }
    }
}
