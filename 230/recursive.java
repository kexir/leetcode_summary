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
    private int count = 0;
    private int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return ans;
    }
    public void kthSmallestHelper(TreeNode root, int k) {
        if(root == null) {
            return ;
        }
        kthSmallestHelper(root.left, k);
        count ++;
        if(count == k) {
            ans = root.val;
            return ;
        }
        kthSmallestHelper(root.right,k);
    }
}