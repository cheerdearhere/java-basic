
package step05_designPatterns.iterator.after;

import step05_designPatterns.iterator.before.Post;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("design patterns");
        board.addPost("아비투스");
        board.addPost("정신병의 나라에서 왔습니다");

        //FIFO
        List<Post> posts = board.getPosts();
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()) {
            Post post = iterator.next();
            System.out.println(post.getTitle());
        }
        //LIFO
        Collections.sort(posts,(p1,p2)->p2.getRegIndex().compareTo(p1.getRegIndex()));
        Iterator<Post> iterator2 = board.getDefaultIterator();
        while(iterator2.hasNext()) {
            Post post = iterator2.next();
            System.out.println(post.getTitle());
        }
    }
}
