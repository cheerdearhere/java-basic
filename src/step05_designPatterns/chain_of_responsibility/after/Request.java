package step05_designPatterns.chain_of_responsibility.after;

public class Request {
    private String body;
    public Request(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

}
