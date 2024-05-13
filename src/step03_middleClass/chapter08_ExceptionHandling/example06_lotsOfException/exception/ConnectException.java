package step03_middleClass.chapter08_ExceptionHandling.example06_lotsOfException.exception;

public class ConnectException extends NetworkClientException {
    private final String address;
    public ConnectException(String address, int statusCode, String message) {
        super(statusCode, message);
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
}
