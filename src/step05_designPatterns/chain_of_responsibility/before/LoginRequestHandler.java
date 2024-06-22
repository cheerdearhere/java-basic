package step05_designPatterns.chain_of_responsibility.before;

public class LoginRequestHandler extends RequestHandler{
    @Override
    public void handler(Request request) {
        System.out.println("userId: frf01");
        System.out.println("password: ******");

        super.handler(request);
    }
}
