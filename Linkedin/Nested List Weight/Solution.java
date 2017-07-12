public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {// 5ms first version
        ArrayList<Integer> level = new ArrayList<Integer>();
        depthSumInverseHelper(nestedList, 0, level);
        int ans = 0;
        for(int i = 0; i < level.size(); i++) {
            ans += level.get(i) * (level.size()-i);
        }
        return ans;
    }
    public void depthSumInverseHelper(List<NestedInteger> nestedList, int depth, ArrayList<Integer> level) {
        if(nestedList == null) {
            return ;
        }
        if(depth == level.size()) {
            level.add(0);
        }
        for(NestedInteger curt : nestedList) {
            if(curt.isInteger()) {
                int prev = level.get(depth);
                level.set(depth, curt.getInteger()+prev);
            } else {
                depthSumInverseHelper(curt.getList(), depth+1, level);
            }
        }
    }
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int ans = 0;
        int prev = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        queue.addAll(nestedList);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                NestedInteger curt = queue.poll();
                if(curt.isInteger()) {
                    // <-- prev is not reset to 0
                    prev += curt.getInteger();
                } else {
                    queue.addAll(curt.getList());
                }
            }
            ans += prev;
        }
        return ans;
    }
    
}