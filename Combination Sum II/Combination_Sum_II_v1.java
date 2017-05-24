public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, 0, target, visited, new ArrayList<Integer>(), result);
        return result;
    }
    public void combinationSum2Helper(int[] candidates, int pos, int remainTarget, 
                                      boolean[] visited, ArrayList<Integer> temp, List<List<Integer>>result){
        if(remainTarget == 0){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }
        for(int i = pos; i < candidates.length && remainTarget >= candidates[i]; i++){
            if(i != 0 && candidates[i] == candidates[i-1] && !visited[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            visited[i] = true;
            combinationSum2Helper(candidates, i+1, remainTarget-candidates[i], visited, temp, result);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}