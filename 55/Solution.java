public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int farthest = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= farthest && nums[i]+i > farthest) {
                farthest = nums[i]+i;
            }
        }
        return farthest >= nums.length-1;
    }
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        if(nums == null || nums.length == 0) {
            return false;
        }
        boolean[] DP = new boolean[nums.length];
        DP[0] = true;
        for(int i = 1; i< nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(DP[j] && i-j <= nums[j]) {
                    DP[i] = true;
                    break;
                }
            }
        }
        return DP[nums.length-1];
    }
}