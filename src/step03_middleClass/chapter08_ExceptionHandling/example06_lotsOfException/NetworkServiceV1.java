package step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;
import step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException.exception.AnotherNetworkException;
import step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException.exception.ConnectException;
import step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException.exception.NetworkClientException;
import step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException.exception.SendException;

public class NetworkServiceV1 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);
        client.initError(data);
        try {
            client.connect();
            client.send(data);
        }
        catch (ConnectException e) {
            System.out.println("[연결 오류] 코드: "+e.getStatusCode()+"/ 서버: "+e.getAddress()+"/ 메시지: "+e.getMessage());
        }
        catch(SendException|AnotherNetworkException e) {
            e.printStackTrace();
        }
        catch (NetworkClientException e) {
            System.out.println("[네트워크 오류] 코드: "+e.getStatusCode()+" 메시지: "+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("[알 수 없는 오류] 에러 클래스: "+e.getClass().getName()+" 메시지: "+e.getMessage());
        }
        finally {
            client.disconnect();
        }
    }
    private boolean isError(String resultMessage){
        return !resultMessage.equals(NetworkStatus.SUCCESS.getStatusName());
    }
}
