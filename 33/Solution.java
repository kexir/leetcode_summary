public class Solution {
    public int search(int[] nums, int target) {//14ms
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target >= nums[start]) {
                if(nums[mid] > nums[start] && nums[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if(nums[mid] < nums[start] && nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if(nums[start] == target) {
            return start;
        }
        if(nums[end] == target) {
            return end;
        }
        return -1;
    }
}