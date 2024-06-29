package step05_designPatterns.iterator.before;

import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("design patterns");
        board.addPost("아비투스");
        board.addPost("정신병의 나라에서 왔습니다");

        //FIFO
        List<Post> posts = board.getPosts();
        for(int i=0; i<posts.size(); i++){
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }

        //LIFO
        Collections.sort(posts,(p1,p2)->p2.getRegIndex().compareTo(p1.getRegIndex()));
        for(int i=0; i<posts.size(); i++){
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }
    }
}
