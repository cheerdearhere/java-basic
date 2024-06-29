package step05_designPatterns.iterator.customized;

public class Post implements BoardContent{
    private final String title;
    private Integer regIndex;// LocalDateTime은 성능에 따라 시간 차이가 안나기도...
    public Post(String title, Integer regIndex) {
        this.title = title;
        this.regIndex=regIndex;
    }
    public String getTitle() {
        return title;
    }
    public Integer getRegIndex() {
        return regIndex;
    }

}
