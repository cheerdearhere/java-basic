package step05_designPatterns.chain_of_responsibility.after;

public class PrintRequestHandler extends RequestHandler{

    public PrintRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handler(Request request) {
        System.out.println("print body: "+request.getBody());
        super.handler(request);
    }
}
