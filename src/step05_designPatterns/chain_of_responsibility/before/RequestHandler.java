package step05_designPatterns.chain_of_responsibility.before;

public class RequestHandler {
    public void handler(Request request) {
        //Single Responsibility Principle 위배
//        System.out.println("has Authority? or Role?");
//        System.out.println("check Authentication");

        System.out.printf("request: %s\n", request.getBody());
    }
}
