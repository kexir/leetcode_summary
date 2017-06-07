public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {//14ms
        int max = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                temp ++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        return Math.max(max, temp);
    }
    public int findMaxConsecutiveOnes(int[] nums) {//10ms
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = 0;
            while(i < nums.length && nums[i] == 1) {
                temp++;
                i++;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}