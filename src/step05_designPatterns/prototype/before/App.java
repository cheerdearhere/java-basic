package step05_designPatterns.prototype.before;

public class App {
    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("hong-gil-dong");
        repository.setName("live-study");

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(1);
        issue.setTitle("1주차: JVM 처리 과정");

        String url = issue.getUrl();
        System.out.println("url = " + url);

        //새로운 이슈의 경우 이슈 정보만 있으면 되도록.
//        GithubIssue issue2 = new GithubIssue(repository); 이부분을 clone으로 처리하고 싶음
//        issue2.setId(1);
//        issue2.setTitle("1주차: JVM 처리 과정");

    }
}
