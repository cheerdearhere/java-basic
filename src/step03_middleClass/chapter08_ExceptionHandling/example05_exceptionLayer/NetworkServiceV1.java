package step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;
import step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer.exception.ConnectException;
import step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer.exception.NetworkClientException;
import step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer.exception.SendException;

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
            System.out.println("[연결 오류] 코드: "+e.getStatusCode()+"/ 서버: "+e.getAddress()+"/ 메세지: "+e.getMessage());
        }
        catch (SendException e) {
            System.out.println("[전송 오류] 코드: "+e.getStatusCode()+"/ 전송 데이터: "+e.getSendData()+" 메세지: "+e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            client.disconnect();
        }
    }
}
