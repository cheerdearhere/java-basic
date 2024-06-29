package step05_designPatterns.iterator.customized;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board{
    private final List<BoardContent> contents;
    public Board() {
        contents = new ArrayList<>();
    }
    public void addContent(String content){
        contents.add(new Post(content, contents.size()));
    }
    public List<BoardContent> getContents(){
        return contents;
    }
    public Iterator<BoardContent> getDefaultIterator(){
        return contents.iterator();
    }
    public Iterator<BoardContent> getRecentIterator(){
        return new RecentContentsIterator<>(this.contents);
    }
}
