package step05_designPatterns.iterator.before;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Post> posts;
    public Board() {
        posts = new ArrayList<>();
    }
    public void addPost(String content){
        posts.add(new Post(content, posts.size()));
    }
    public List<Post> getPosts(){
        return posts;
    }
}
