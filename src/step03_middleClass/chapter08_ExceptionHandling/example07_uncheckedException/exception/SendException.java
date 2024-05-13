package step03_middleClass.chapter08_ExceptionHandling.example07_uncheckedException.exception;

public class SendException extends NetworkClientException {
    private final String sendData;
    public SendException(String sendData, int statusCode, String message) {
        super(statusCode, message);
        this.sendData = sendData;
    }
    public String getSendData() {
        return sendData;
    }
}
