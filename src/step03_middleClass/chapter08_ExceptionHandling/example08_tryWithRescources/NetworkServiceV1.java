package step03_middleClass.chapter08_ExceptionHandling.example08_tryWithRescources;

public class NetworkServiceV1 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        try(NetworkClient client = new NetworkClient(address)) {
            client.initError(data);
            client.connect();
            client.send(data);
        }catch(Exception e) {
            System.out.println("catch!! "+e.getMessage());
        }
    }
}
