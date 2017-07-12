public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(nums[start] != target && nums[end] != target) {
            return new int[]{-1,-1};
        }
        ans[0] = nums[start] == target? start:end;
        end = nums.length-1;
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        ans[1] =  nums[end] == target? end:start;
        return ans;
    }
}