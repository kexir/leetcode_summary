public class ZigzagIterator {
    private Iterator<Integer> it1;
    private Iterator<Integer> it2;
    private int turn;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {// 4 ms
        it1 = v1.listIterator();
        it2 = v2.listIterator();
        turn = 0;
    }

    public int next() {
        if(turn == 0) {
            turn = 1;
            return it1.hasNext()? it1.next():it2.next();
        }else {
            turn = 0;
            return it2.hasNext()? it2.next():it1.next();
        }
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */