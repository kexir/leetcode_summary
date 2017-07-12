import java.util.List;
import java.util.Iterator;

public class ZigzagIterator {
    private LinkedList<Iterator<Integer>> itList;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {//6 ms
        itList = new LinkedList<Iterator<Integer>>();
        if(!v1.isEmpty()) {
            itList.add(v1.listIterator());
        }
        if(!v2.isEmpty()) {
            itList.add(v2.listIterator());
        }
    }

    public int next() {
        Iterator<Integer> poll = itList.remove();
        int ans = poll.next();
        if(poll.hasNext()){
            itList.add(poll);
        }
        return ans;
    }

    public boolean hasNext() {
        return itList.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */