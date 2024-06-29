package step05_designPatterns.mediator.after;

public class Guest extends Customer{
    private String acceptPath;
    public Guest(long id, Integer roomNumber, String name) {
        super(id, roomNumber, name);
    }
    public String getAcceptPath() {
        return acceptPath;
    }

    public void setAcceptPath(String acceptPath) {
        this.acceptPath = acceptPath;
    }
}
