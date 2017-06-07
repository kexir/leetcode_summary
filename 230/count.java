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
        int left = countHelper(root.left);
        if(k <= left) {
            return kthSmallest(root.left, k);
        } else if (k == left+1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k-left-1);
        }
    }
    public int countHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + countHelper(root.left) + countHelper(root.right);
    }
}