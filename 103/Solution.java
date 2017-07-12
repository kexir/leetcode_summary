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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flip = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            flip = !flip;
            for(int i = 0; i < size; i++) {
                TreeNode curt = queue.poll();
                if(flip) {
                    list.addFirst(curt.val);
                } else {
                    list.addLast(curt.val);
                }
                if(curt.left != null) {
                    queue.offer(curt.left);
                }
                if(curt.right != null) {
                    queue.offer(curt.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) {
            return ans;
        }
        zigzagHelper(root, ans, 1);
        return ans;
    }
    public void zigzagHelper(TreeNode root, List<List<Integer>> ans, int level) {
        if(root == null) {
            return;
        }
        if(level > ans.size()){
            ans.add(new ArrayList<Integer>());
        }
        if(level % 2 == 1) {
            ans.get(level-1).add(root.val);
        } else {
            ans.get(level-1).add(0,root.val);
        }
        zigzagHelper(root.left, ans, level+1);
        zigzagHelper(root.right, ans, level+1);
    }
}