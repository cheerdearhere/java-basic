package step05_designPatterns.chain_of_responsibility.before;

public class AuthRequestHandler extends RequestHandler{
    @Override
    public void handler(Request request) {
        System.out.println("has Authority? or Role?");
        System.out.println("check Authentication");

        super.handler(request);
    }
}
