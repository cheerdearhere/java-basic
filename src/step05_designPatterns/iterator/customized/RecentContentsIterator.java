package step05_designPatterns.iterator.customized;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecentContentsIterator<T extends BoardContent> implements Iterator<T> {
    private Iterator<T> internalIterator;

    public RecentContentsIterator(List<T> contents) {
        List<T> tempList = contents;
        Collections.sort(tempList,(c1,c2)->c2.getRegIndex().compareTo(c1.getRegIndex()));
        this.internalIterator = (Iterator<T>) tempList.iterator();
    }
    @Override
    public boolean hasNext() {
        return this.internalIterator.hasNext();
    }

    @Override
    public T next() {
        return this.internalIterator.next();
    }
}
