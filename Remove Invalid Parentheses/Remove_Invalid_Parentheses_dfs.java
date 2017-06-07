import java.util.List;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(removeInvalidParentheses(s));
    }
    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        removeInvalidParenthesesHelper(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    public static void removeInvalidParenthesesHelper(String s, List<String> ans, int last_i, int last_j, char[] flag) {
        for(int stack = 0, i = last_i; i < s.length(); i++) {
            if(s.charAt(i) == flag[0]) {
                stack ++;
            }
            if(s.charAt(i) == flag[1]) {
                stack --;
            }
            if(stack >= 0) {
                continue;
            }
            for(int j = last_j; j <= i; j++) {
                if(s.charAt(j) == flag[1] && (j == last_j || s.charAt(j-1) != flag[1])) {
                    removeInvalidParenthesesHelper(s.substring(0,j)+s.substring(j+1,s.length()), ans, i, j, flag);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (flag[0] == '(') {
            removeInvalidParenthesesHelper(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }
}