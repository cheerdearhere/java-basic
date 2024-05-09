package step03_middleClass.chapter08_ExceptionHandling.example03_useReturnValue;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;

public class NetworkServiceV2 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);

        client.initError(data);
        String connectResult = client.connect();
        //결과가 성공이 아니다 == 오류다
        if(isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류코드("+NetworkStatus.FAIL_CONNECTED.getStatusName()+"): "+NetworkStatus.FAIL_CONNECTED.getStatusName());
        }else {
            String sendResult = client.send(data);
            if(isError(sendResult)) {
                System.out.println("[네트워크 오류 발생] 오류코드("+NetworkStatus.FAIL_SEND.getStatusName()+"): "+NetworkStatus.FAIL_SEND.getStatusName());
            }
        }
        client.disconnect();
    }
    private boolean isError(String resultMessage){
        return !resultMessage.equals(NetworkStatus.SUCCESS.getStatusName());
    }
}
