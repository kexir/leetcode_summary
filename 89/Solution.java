public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        if(n == 0) {
            return ans;
        }
        for(int i = 0; i < n; i++) {
            int size = ans.size();
            for(int j = size-1; j >= 0; j--) {
                int next = ans.get(j) + size;
                ans.add(next);
            }
        }
        return ans;
    }
}