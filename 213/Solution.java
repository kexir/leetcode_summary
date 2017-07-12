public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,1,3,1000};
        rob(nums);
    }
    public static int rob(int[] nums) {//1 ms
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] s0 = new int[nums.length-1];
        int[] s1 = new int[nums.length-1];
        for(int i = 0; i < nums.length-1; i++) {
            if(i == 0) {
                s0[i] = nums[i];
            } else if(i == 1) {
                s0[i] = Math.max(nums[i-1], nums[i]);
            } else {
                s0[i] = Math.max(nums[i]+s0[i-2], s0[i-1]);
            }
        }
        for(int i = 0; i < nums.length-1; i++) {
            if(i == 0) {
                s1[i] = nums[i+1];
            } else if(i == 1) {
                s1[i] = Math.max(nums[i], nums[i+1]); 
        
            } else {
                s1[i] = Math.max(nums[i+1]+s1[i-2], s1[i-1]);
            }
            System.out.println(s1[i]);
        }
        return Math.max(s0[nums.length-2], s1[nums.length-2]);
    }
}