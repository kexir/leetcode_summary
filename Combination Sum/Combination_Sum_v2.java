public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;
    }
    public void combinationSumHelper(int[] candidates, List<List<Integer>> result, 
                                    List<Integer> temp, int pos,int remainTarget){
        if(remainTarget == 0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = pos; i < candidates.length && remainTarget >= candidates[i]; i++){
            temp.add(candidates[i]);
            combinationSumHelper(candidates, result, temp, i, remainTarget-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
}