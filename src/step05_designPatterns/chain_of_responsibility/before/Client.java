package step05_designPatterns.chain_of_responsibility.before;

public class Client {
    public static void main(String[] args) {
        Request request = new Request("무궁화 꽃이 피었습니다.");
//        RequestHandler requestHandler = new RequestHandler();
//        RequestHandler requestHandler = new LoginRequestHandler();
        RequestHandler requestHandler = new AuthRequestHandler();
        requestHandler.handler(request);
    }
}
