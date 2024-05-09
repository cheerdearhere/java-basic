package step03_middleClass.chapter08_ExceptionHandling.example01_firstModule;

import step03_middleClass.chapter08_ExceptionHandling.NetworkStatus;

public class NetworkClient {
    private final String address;

    public NetworkClient(String address) {
        this.address = address;
    }

    public String connect(){
        //연결 성공
        System.out.println(address+" 서버에 연결 성공");
        return NetworkStatus.SUCCESS.getStatusName();
    }
    public String send(Object data){
        //전송성공
        System.out.println(address+" 서버에 데이터 전송: "+data.toString());
        return NetworkStatus.SUCCESS.getStatusName();
    }
    public void disconnect(){
        System.out.println(address+" 서버 연결 해제");
    }

}
