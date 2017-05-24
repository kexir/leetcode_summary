public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(nums, temp, result, 0);
        return result;
    }
    public void permuteHelper(int[] nums, ArrayList<Integer> temp, List<List<Integer>> result, int begin) {
        if(temp.size() == nums.length){
            result.add(new ArrayList(temp));
            return ;
        }
        for(int i = begin; i < nums.length; i++) {
            swap(nums, begin, i);
            temp.add(nums[begin]);
            permuteHelper(nums, temp, result, begin+1);
            temp.remove(temp.size()-1);
            swap(nums, begin, i);
        }
    }
    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}