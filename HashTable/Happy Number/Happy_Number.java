public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            int result = 0;
            while ( n != 0 ) {
                result += (n%10)*(n%10);
                n /= 10;
            }
            if (result == 1){
                return true;
            } else  {
                n = result;
            }
        }
        return false;
    }
}