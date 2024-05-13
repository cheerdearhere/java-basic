package step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException.exception;

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
