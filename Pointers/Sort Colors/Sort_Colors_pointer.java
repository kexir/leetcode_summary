public class Solution {
    public void sortColors(int[] nums) {
        
        int firstPosOfOne = 0;
        boolean meetOne = false;
        int PosOfTwo = nums.length-1;
        int i = 0;
        while(i < nums.length){
            if (nums[i] == 0 ){
                nums[i] = nums[firstPosOfOne];
                nums[firstPosOfOne] = 0;
                firstPosOfOne++;
                i++;
            }else if (nums[i] == 1 ) {
                if (!meetOne) {
                    meetOne = true;
                    firstPosOfOne = i;
                }
                i++;
            } else if (nums[i] == 2) {
                if (i > PosOfTwo) {
                    break;
                }
                nums[i] = nums[PosOfTwo];
                nums[PosOfTwo] = 2;
                PosOfTwo --;
            }
        }
    }
}
