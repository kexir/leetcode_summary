/*public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        combineHelper(1,n,k,path,ans);
        return ans;
    }
    public void combineHelper(int start, int end, int k, List<Integer> path, List<List<Integer>> ans){
        if(path.size() == k){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i <= end; i++){
            path.add(i);
            combineHelper(i+1,end,k,path,ans);
            path.remove(path.size()-1);
        }
    }
}*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        combineHelper(1,n,k,path,ans);
        return ans;
    }
    public void combineHelper(int start, int end, int k, List<Integer> path, List<List<Integer>> ans){
        if(k == 0){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i <= end-k+1; i++){
            path.add(i);
            combineHelper(i+1,end,k-1,path,ans);
            path.remove(path.size()-1);
        }
    }
}

/*public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k == n || k == 0){
            List<Integer> path = new ArrayList<Integer>();
            for(int i = 1; i <= k; i++){
                path.add(i);
            }
            return new ArrayList<>(Arrays.asList(path));
        }
        List<List<Integer>> ans = combine(n-1,k-1);
        ans.forEach(e -> e.add(n));
        ans.addAll(combine(n-1,k));
        return ans;
    }
}

*/