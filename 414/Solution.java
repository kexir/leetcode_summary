public class Solution {
    public int thirdMax(int[] nums) {//4ms
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int i : nums) {
            if(i > first){
                third = second;
                second = first;
                first = i;
            }
            else if(i == first){
                continue;
            }
            else if(i >  second) {
                third = second;
                second = i;
            }
            else if (i == second){
                continue;
            }
            else if(i>third)
            {
                third = i;
            }
        }
    	return third == Long.MIN_VALUE ? (int)first : (int)third;
    }
    public int thirdMax(int[] nums) {//10ms
        Integer max1 = null, max2 = null, max3 = null;
        for(Integer n : nums) {
            if(n.equals(max1) || n.equals(max2) || n.equals(max3)) {
                continue;
            }
            if(max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(max2 == null || (n < max1 && n > max2)) {
                max3 = max2;
                max2 = n;
            } else if(max3 == null || (n < max2 && n > max3)) {
                max3 = n;
            }
        }
        return max3 == null? max1:max3;
    }
}