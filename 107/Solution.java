import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        System.out.println(levelOrderBottom(root));
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new LinkedList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode curt = queue.poll();
                path.add(curt.val);
                if(curt.left != null) {
                    queue.offer(curt.left);
                }
                if(curt.right != null) {
                    queue.offer(curt.right);
                }
            }
            ans.addFirst(path);
        }
        return ans;
    }
}