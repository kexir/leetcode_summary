public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(nums, result, temp, visited);
        return result;
    }
    public void permuteUniqueHelper(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, boolean[] visited){
        if(temp.size() == nums.length){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i != 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            permuteUniqueHelper(nums, result, temp, visited);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}