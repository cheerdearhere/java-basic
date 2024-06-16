package step05_designPatterns.decorator.before;

public class Client {
    private CommentService commentService;
    public Client(CommentService commentService) {
        this.commentService = commentService;
    }
    private void writeComment(String comment){
        commentService.addComment(comment);
    }
    public static void main(String[] args) {
//        Client client = new Client(new CommentService());
//        Client client = new Client(new TrimmingCommentService());
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("오징어 게임");
        client.writeComment("백문이불여...");
        client.writeComment("http://www.never.co.kr");
    }
}
