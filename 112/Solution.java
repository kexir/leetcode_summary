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
    public boolean hasPathSum(TreeNode root, int sum) {//1ms DFS
        if(root == null) {
            return false;
        }
        if(sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasPathSum(root.left, sum-root.val);
        boolean right = hasPathSum(root.right, sum-root.val);
        return left || right;
    }
    public boolean hasPathSum2(TreeNode root, int sum) {//1ms DFS improved
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}