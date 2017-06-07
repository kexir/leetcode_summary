public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k == 0 || n == 0 || n > 9*k) {
            return result;
        }
        combinationSum3Helper(n,k,0,new ArrayList<Integer>(), result);
        return result;
    }
    public void combinationSum3Helper(int remainTarget, int k, int pos, ArrayList<Integer> temp, List<List<Integer>> result) {
        if(k == 0 && remainTarget == 0){
            result.add(new ArrayList<Integer>(temp));
        }
        if (k == 0 || remainTarget == 0) {
            return ;
        }
        for(int i = pos+1; i < 10 && i <= remainTarget; i++) {
            temp.add(i);
            combinationSum3Helper(remainTarget-i,k-1,i,temp, result);
            temp.remove(temp.size()-1);
        }
    }
}