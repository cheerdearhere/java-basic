package step05_designPatterns.decorator.before;

public class SpamFilteringCommentService extends CommentService {
    @Override
    public void addComment(String comment) {
        boolean isSpam = isSpam(comment);
        super.addComment(comment);
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
