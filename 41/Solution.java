public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] > 0 && nums[i] <= n && nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
                continue;
            } 
            i++;
        }
        
        i = 0;
        while(i < n) {
            if(nums[i] != i+1) {
                break;
            }
            i++;
        }
        return i+1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}