package step03_middleClass.chapter08_ExceptionHandling.example04_checkedException;

public class NetworkClientException extends Exception{
    private final String errorCode;

    public NetworkClientException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
