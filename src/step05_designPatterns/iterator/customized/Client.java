package step05_designPatterns.iterator.customized;

import javax.swing.text.AbstractDocument;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addContent("design patterns");
        board.addContent("아비투스");
        board.addContent("정신병의 나라에서 왔습니다");

        //FIFO
        Iterator<BoardContent> dit = board.getDefaultIterator();
        while (dit.hasNext()){
            BoardContent content = dit.next();
            System.out.println(content.getTitle());
        }
        //LIFO
        Iterator<BoardContent> rit = board.getRecentIterator();
        while (rit.hasNext()){
            BoardContent content = rit.next();
            System.out.println(content.getTitle());
        }

    }
}
