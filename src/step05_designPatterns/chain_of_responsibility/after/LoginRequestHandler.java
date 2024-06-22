package step05_designPatterns.chain_of_responsibility.after;

public class LoginRequestHandler extends RequestHandler{

    public LoginRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handler(Request request) {
        System.out.println("userId: frf01");
        System.out.println("password: ******");

        super.handler(request);
    }
}
