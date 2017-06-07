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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode q = stack.pop();
                if(++count == k) {
                    return q.val;
                }
                p = q.right;
            }
        }
        return Integer.MAX_VALUE;
    }
}