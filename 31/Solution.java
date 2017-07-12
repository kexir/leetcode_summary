public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 1;
        while(i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        swapList(nums, i, nums.length-1);
        if(i != 0) {
            int j = i;
            while (nums[j] <= nums[i-1]) {
                j++;
            }
            swapItem(nums, i-1, j);
        }
    }
    public void swapList(int[] nums, int i, int j) {
        while(i < j) {
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
    public void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}