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
    public int findBottomLeftValue(TreeNode root) {//8 ms
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(root.val);
        findBottomLeftValueHelper(root, ans, 1);
        return ans.get(ans.size()-1);
    }
    public void findBottomLeftValueHelper(TreeNode root, ArrayList<Integer> ans, int level) {
        if(root == null) {
            return ;
        }
        if(level > ans.size()) {
            ans.add(root.val);
        }
        findBottomLeftValueHelper(root.left, ans, level+1);
        findBottomLeftValueHelper(root.right, ans, level+1);
    }
}