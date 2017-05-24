public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, result, temp, 0, 0, target);
        return result;
    }
    public void combinationSumHelper(int[] candidates, List<List<Integer>> result, 
                                    List<Integer> temp, int pos, int sumSoFar, int target){
        if(pos == candidates.length || sumSoFar > target){
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            temp.add(candidates[i]);
            sumSoFar += candidates[i];
            if(sumSoFar == target){
                result.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
                continue;
            }
            combinationSumHelper(candidates, result, temp, i, sumSoFar, target);
            temp.remove(temp.size()-1);
            sumSoFar -= candidates[i];
        }
    }
}