package step05_designPatterns.prototype.after;

import java.util.Objects;

public class GithubIssue implements Cloneable{
    private long id;
    private String title;
    private GithubRepository githubRepository;
    public GithubIssue(GithubRepository githubRepository){
        this.githubRepository = githubRepository;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl(){
        return String.format("https://github.com/%s/%s/%s/%s",
                githubRepository.getUser(),
                githubRepository.getName(),
                "issues",
                id
        );
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser(this.githubRepository.getUser());
        repository.setName(this.githubRepository.getName());

        GithubIssue issue = new GithubIssue(repository);
        issue.setId(this.id);
        issue.setTitle(this.title);

        return issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GithubIssue that)) return false;
        return getId() == that.getId() && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(githubRepository, that.githubRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), githubRepository);
    }
}
