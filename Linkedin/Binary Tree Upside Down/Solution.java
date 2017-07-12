/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode newRoot = upsideDownBinaryTree2(root);
		System.out.println(newRoot.left.val);
	}
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode newRoot = root;
        if(root.left != null) {
            newRoot = upsideDownBinaryTree(root.left);
            root.left.left = root.right;
            root.left.right = root;
            root.left = null;
            root.right = null;
        }
        return newRoot;
    }
    public static TreeNode upsideDownBinaryTree2(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode prev = null;
        TreeNode curt = root;
        TreeNode temp = null;
        TreeNode next = null;
        while(curt != null) {
            next = curt.left;

            curt.left = temp;
            temp = curt.right;
            curt.right = prev;

            prev = curt;
            curt = next;
        }
        return prev;
    }
}