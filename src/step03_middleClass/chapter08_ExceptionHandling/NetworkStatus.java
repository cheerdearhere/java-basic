package step03_middleClass.chapter08_ExceptionHandling;

public enum NetworkStatus {
    SUCCESS(200,"success"),
    FAIL_SEND(400, "sendError"),
    FAIL_CONNECTED(500,"connectError"),
    ;

    final int statusCode;
    final String statusName;

    NetworkStatus(int statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
    public int getStatusCode() {
        return statusCode;
    }
}
