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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        rightSideViewHelper(root, 0, ans);
        return ans;
    }
    public void rightSideViewHelper(TreeNode root, int level, List<Integer> ans) {
        if(root == null) {
            return;
        }
        if(level == ans.size()) {
            ans.add(root.val);
        } 
        rightSideViewHelper(root.right, level+1, ans);
        rightSideViewHelper(root.left, level+1, ans);
        
    }
}