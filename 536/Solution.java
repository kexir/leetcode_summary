/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode str2tree(String s) {//53 ms
        if(s == null || s.length() == 0) {
            return null;
        }
        int start = 0;
        for(; start < s.length(); start++) {
            if(s.charAt(start) == '(') {
                break;
            }
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0,start)));
        boolean isLeft = true;
        int count = 0;
        for(int i = start; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++; 
            } else if(s.charAt(i) == ')') {
                count--;
            }
            if(count == 0 && isLeft) {
                root.left = str2tree(s.substring(start+1,i));
                start = i+2;
                isLeft = false;
            } else if(count == 0 && start < s.length()){
                root.right = str2tree(s.substring(start,i));
            }
        }
        return root;
    }
    public TreeNode str2tree2(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        int start = 0;
        for(; start < s.length(); start++) {
            if(s.charAt(start) == '(') {
                break;
            }
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0,start)));
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int i = start;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                int j = i+1;
                for( ;j< s.length() && s.charAt(j) != ')' && s.charAt(j) != '('; j++) ;
                stack.push(new TreeNode(Integer.parseInt(s.substring(i+1,j))));
                i = j;
            }
            if(s.charAt(i) == ')') {
                TreeNode temp = stack.pop();
                if(stack.peek().left == null) {
                    stack.peek().left = temp;
                } else {
                    stack.peek().right = temp;
                }
                i++;
            }
        }
        return root;
    }
}

public class Solution {
    int i;
    public TreeNode str2tree(String s) {//10ms
        if(i>=s.length()) return null;
        TreeNode r;
        if(s.charAt(i)=='-') {
            i++;
            r = new TreeNode(-parseint(s));
        }
        else {
            r = new TreeNode(parseint(s));
        }
        i++;
        if(i==s.length()||s.charAt(i)==')') {
            return r;
        }
        else if(s.charAt(i)=='(') {
            i++;
            if(r.left==null) {
                r.left = str2tree(s);
                i++;
                if(i<s.length()&&s.charAt(i)=='('){
                    i++;
                    r.right = str2tree(s);
                    i++;
                }
            }
        }
        return r;
    }
    int parseint(String s) {
        int v = 0;
        while(i<s.length()&&s.charAt(i)>=48&&s.charAt(i)<=57) {
            v*=10;
            v+=(s.charAt(i)-48);
            i++;
        }
        i--;
        return v;
    }
}