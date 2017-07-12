public class Solution {
    public int longestValidParentheses(String s) { //20ms
        int ans = 0;
        int[] DP = new int[s.length()];
        if(s == null || s.length() == 0) {
            return ans;
        }
        for(int i = 0; i < s.length(); i++) {
            if(i != 0 && s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    DP[i] = i-2 >= 0? DP[i-2] +2: 2;
                } else if(i-DP[i-1]-1 >=0 && s.charAt(i-DP[i-1]-1) == '(') {
                    DP[i] = i-DP[i-1]-2 >= 0? DP[i-1]+2+DP[i-DP[i-1]-2]: DP[i-1]+2;
                }
                ans = Math.max(ans, DP[i]);
            }
        }
        return ans;
    }
    public int longestValidParentheses2(String s) { //25ms
        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int lastInvalid = -1;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    lastInvalid = i;
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        ans = Math.max(ans, i-lastInvalid);
                    } else {
                        ans = Math.max(ans, i-stack.peek());
                    }
                }
            }
        }
        return ans;
    }
    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}