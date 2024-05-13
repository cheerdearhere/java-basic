package step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception;

public class AnotherNetworkException extends NetworkClientException {
    private final String anotherMessage;
    public AnotherNetworkException(String anotherMessage, int statusCode, String message) {
        super(statusCode, message);
        this.anotherMessage = anotherMessage;
    }

    public String getAnotherMessage() {
        return anotherMessage;
    }
}
