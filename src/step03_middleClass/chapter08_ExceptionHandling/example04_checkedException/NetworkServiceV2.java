package step03_middleClass.chapter08_ExceptionHandling.example04_checkedException;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;


public class NetworkServiceV2 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);

        client.initError(data);
        try {
            client.connect();
        } catch (NetworkClientException ne) {
            System.out.println("[오류] 코드: "+ne.getErrorCode()+"/ 메세지: "+ne.getMessage());
            return;
        }
        try {
            client.send(data);
        } catch (NetworkClientException ne) {
            System.out.println("[오류] 코드: "+ne.getErrorCode()+"/ 메세지: "+ne.getMessage());
            return;
        }
        client.disconnect();
    }
    private boolean isError(String resultMessage){
        return !resultMessage.equals(NetworkStatus.SUCCESS.getStatusName());
    }
}
