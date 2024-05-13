package step03_middleClass.chapter08_ExceptionHandling.example04_checkedException;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;


public class NetworkServiceV4 {
    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClient client = new NetworkClient(address);
        client.initError(data);
        try {
            client.connect();
            client.send(data);
        }
        catch (NetworkClientException ne) {
//            throw new RuntimeException("ex");// 예외 체크용일뿐 확인 후 삭제
            System.out.println("[오류] 코드: "+ne.getErrorCode()+"/ 메세지: "+ne.getMessage());
        }
        catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            client.disconnect();
        }
    }
}
