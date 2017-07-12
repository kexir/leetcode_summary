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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {//3 ms
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        pathSumHelper(root, sum, ans, path);
        return ans;
    }
    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        pathSumHelper(root.left, sum-root.val, ans, path);
        pathSumHelper(root.right, sum-root.val, ans, path);
        path.remove(path.size()-1);
    }
}