public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(nums, temp, result);
        return result;
    }
    public void permuteHelper(int[] nums, ArrayList<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == nums.length){
            result.add(new ArrayList(temp));
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            permuteHelper(nums, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}