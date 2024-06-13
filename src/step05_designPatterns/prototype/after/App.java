package step05_designPatterns.prototype.after;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
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
//        issue2.setId(2);
//        issue2.setTitle("2주차: JVM 사용");

        GithubIssue issue2 = (GithubIssue) issue.clone();//new GithubIssue(repository);
        issue2.setId(2);
        issue2.setTitle("2주차: JVM 사용");
        System.out.println("issue2.getUrl(): " + issue2.getUrl());

        GithubIssue clone = (GithubIssue) issue.clone();
        System.out.println("clone = " + clone);
        System.out.println("issue = " + issue);
        System.out.println("clone==issue: " + (clone==issue));
        System.out.println("clone.equals(issue): " + clone.equals(issue));
    }
}
