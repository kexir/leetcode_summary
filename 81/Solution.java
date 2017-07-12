public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length-1;
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]) {
                return true;
            }
            if(nums[start] == nums[end] && nums[start] == nums[mid]) {
                end --;
            } else {
                if(target >= nums[start]) {
                    if(nums[mid] >= nums[start] && nums[mid] < target) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                } else {
                    if(nums[mid] <= nums[end] && nums[mid] > target) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            }
            
        }
        if(nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}