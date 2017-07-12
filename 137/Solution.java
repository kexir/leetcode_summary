public class Solution {
    public int singleNumber(int[] nums) {//14ms
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int[] bits = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                bits[i] += nums[j] >> i & 1;
                bits[i] %= 3;
            }
            result |= bits[i] << i;
        }
        return result;
    }
    public int singleNumber2(int[] nums) {//1ms
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < nums.length; i++) {
           twos |= ones & nums[i];
           ones ^= nums[i];
           int mask = ~(ones & twos);
           ones &= mask;
           twos &= mask;
        }
        return ones;
    }
    public int singleNumber3(int[] nums) {   //00-01-10-00
        int bit1 = 0, bit2 = 0;
        for (int i = 0; i < nums.length; i++) {
            bit1 = (bit1 ^ nums[i]) & (~bit2);
            bit2 = (bit2 ^ nums[i]) & (~bit1);
        }
        return bit1;
    }
}