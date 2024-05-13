package step03_middleClass.chapter08_ExceptionHandling.example08_tryWithRescources.exception;

public class NetworkClientException extends RuntimeException{
    private final int statusCode;
    public NetworkClientException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }
}
