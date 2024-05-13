package step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer;


import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;
import step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer.exception.ConnectException;
import step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer.exception.SendException;

public class NetworkClient {
    //immutable variable
    private final String address;
    //mutable variable
    private boolean connectError;
    private boolean sendError;
    //required constructor
    public NetworkClient(String address) {
        this.address = address;
    }
    //public methods
    public void connect() throws ConnectException {
        if(connectError){
            //연결 실패
            throw new ConnectException(
                    address,
                    NetworkStatus.FAIL_CONNECTED.getStatusCode(),
                    address+" 서버 연결 실패: "+NetworkStatus.FAIL_CONNECTED.getStatusName()
            );
        }
        //연결 성공
        System.out.println(address+" 서버에 연결 성공");
//        return NetworkStatus.SUCCESS.getStatusName();
    }
    public void send(Object data) throws SendException {
        if(sendError){
            //전송 실패
            throw new SendException(
                    data.toString(),
                    NetworkStatus.FAIL_SEND.getStatusCode(),
                    address+" 서버에 데이터 전송 실패: "+NetworkStatus.FAIL_SEND.getStatusName()
            );
        }
        //전송 성공
        System.out.println(address+" 서버에 데이터 전송: "+data.toString());
//        return NetworkStatus.SUCCESS.getStatusName();
    }
    public void disconnect(){
        System.out.println(address+" 서버 연결 해제");
    }
    //check error
    public void initError(String message){
        if(message.contains("error1")) connectError = true;
        if(message.contains("error2")) sendError = true;
        
    }

}
