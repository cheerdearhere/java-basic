package step05_designPatterns.iterator.after;

import step05_designPatterns.iterator.before.Post;

import java.util.ArrayList;
import java.util.Iterator;
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
    public Iterator<Post> getDefaultIterator(){
        return posts.iterator();
    }
}
