package step05_designPatterns.chain_of_responsibility.before;

public class Request {
    private String body;
    public Request(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

}
