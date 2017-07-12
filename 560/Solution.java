public class Solution {
    public int subarraySum(int[] nums, int k) {//44 ms
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(preSum.containsKey(sum-k)) {
                ans += preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}