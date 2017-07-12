public class Solution {
    public int majorityElement(int[] nums) {
        int[] bits = new int[32];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 32; j++){
                if(((nums[i] >> j) & 1) == 1){
                    bits[j] ++; 
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] > nums.length/2) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}