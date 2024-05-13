package step03_middleClass.chapter08_ExceptionHandling.example08_tryWithRescources;


import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;
import step03_middleClass.chapter08_ExceptionHandling.example08_tryWithRescources.exception.AnotherNetworkException;
import step03_middleClass.chapter08_ExceptionHandling.example08_tryWithRescources.exception.ConnectException;
import step03_middleClass.chapter08_ExceptionHandling.example08_tryWithRescources.exception.SendException;

public class NetworkClient implements AutoCloseable {
    //immutable variable
    private final String address;
    //mutable variable
    private boolean connectError;
    private boolean sendError;
    private boolean anotherError;
    private boolean anotherNetworkError;
    //required constructor
    public NetworkClient(String address) {
        this.address = address;
    }
    //public methods
    public void connect(){
        if(connectError){
            //연결 실패
            throw new ConnectException(
                    address,
                    NetworkStatus.FAIL_CONNECTED.getStatusCode(),
                    address+" 서버 연결 실패: "+NetworkStatus.FAIL_CONNECTED.getStatusName()
            );
        }
        if(anotherNetworkError){
            throw new AnotherNetworkException(
                    "another network error",
                    NetworkStatus.FAIL_CONNECTED.getStatusCode(),
                    address+" 서버 연결 실패: "+NetworkStatus.FAIL_CONNECTED.getStatusName()
            );
        }
        //연결 성공
        System.out.println(address+" 서버에 연결 성공");
    }
    public void send(Object data) {
        if(sendError){
            //전송 실패
            throw new SendException(
                    data.toString(),
                    NetworkStatus.FAIL_SEND.getStatusCode(),
                    address+" 서버에 데이터 전송 실패: "+NetworkStatus.FAIL_SEND.getStatusName()
            );
        }
        if(anotherError){
            throw new RuntimeException("error3 occurred");
        }
        //전송 성공
        System.out.println(address+" 서버에 데이터 전송: "+data.toString());
    }
    public void disconnect(){
        System.out.println(address+" 서버 연결 해제");
    }
    //check error
    public void initError(String message){
        if(message.contains("error1")) connectError = true;
        if(message.contains("error2")) sendError = true;
        if(message.contains("error3")) anotherError = true;
        if(message.contains("error4")) anotherNetworkError = true;
    }

    @Override
    public void close() /*throws Exception*/ {// 보통 예외를 던지지 않기때문에 throws Exception 제거
        System.out.println("NetworkClient close");
        disconnect();
    }
}
