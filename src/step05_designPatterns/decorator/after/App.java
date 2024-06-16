package step05_designPatterns.decorator.after;

public class App {
    private static boolean enableSpamFilter = true;
   private static boolean enableTrimming = true;
    public static void main(String[] args) {
        //Bean에 따른 처리 로직 변경
        CommentService commentService = new DefaultCommentService();
        if(enableSpamFilter) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }
        if(enableTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }
        Client client = new Client(commentService);
        client.writeComment("오징어 게임");
        client.writeComment("백문이불여...");
        client.writeComment("http://www.never.co.kr");
    }
}
