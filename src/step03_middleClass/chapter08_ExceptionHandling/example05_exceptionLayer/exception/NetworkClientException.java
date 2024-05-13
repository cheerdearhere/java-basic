package step03_middleClass.chapter08_ExceptionHandling.example05_exceptionLayer.exception;

public class NetworkClientException extends Exception{
    private final int statusCode;
    public NetworkClientException(int statusCode,String message) {
        super(message);
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }
}
