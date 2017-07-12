public class Solution {
    public List<List<Integer>> getFactors(int n) {//202 ms
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        getFactorsHelper(n, path, ans, 2);
        return ans;
    }
    public void getFactorsHelper(int n, List<Integer> path, List<List<Integer>> ans, int start) {
        if(n == 1 && path.size() > 1) {
            ans.add(new ArrayList<Integer>(path));
        }
        for(int i = start; i <= n; i++) {
            if((n%i) == 0) {
                path.add(i);
                getFactorsHelper(n/i, path, ans, i);
                path.remove(path.size()-1);
            }
        }
    }
    ppublic void getFactorsHelper(int n, List<Integer> path, List<List<Integer>> ans, int start) {
        for(int i = start; i <= Math.sqrt(n); i++) {
            if((n%i) == 0) {
                path.add(i);
                path.add(n/i);
                ans.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
                getFactorsHelper(n/i, path, ans, i);
                path.remove(path.size()-1);
            }
        }
    }
}