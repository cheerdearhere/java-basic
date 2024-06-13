package step05_designPatterns.prototype.before;

public class GithubIssue {
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
        return String.format("https://github.com/%s/%s/%s/%s",githubRepository.getUser(),githubRepository.getName(),"issues",id);
    }
}
