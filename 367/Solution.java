public class Solution {
    public boolean isPerfectSquare(int num) {//O(sqrt(n))
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
    public boolean isPerfectSquare(int num) {//O(logn)
        int low = 1;
        int high = num;
        while(low <= high) {
            long mid = (low+high) >>> 1;
            if(mid*mid == num) {
                return true;
            } else if(mid*mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}