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
    public TreeNode buildTree(int[] inorder, int[] postorder) {//19 ms
        return buildTreeHelper(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    public TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart >= inEnd || postStart >= postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd-1]);
        int index = find(inorder, inStart, inEnd, root.val);
        if(index == -1) {
            return null;
        }
        root.left = buildTreeHelper(inorder,inStart,index,postorder,postStart,postStart-inStart+index);
        root.right = buildTreeHelper(inorder,index+1,inEnd,postorder,postStart-inStart+index,postEnd-1);
        return root;
    }
    public int find(int[] inorder,int inStart, int inEnd, int target) {
        for(int i = inStart; i < inEnd; i++) {
            if(inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int postIndex = postorder.length-1;
        int inIndex = inorder.length-1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(postorder[postIndex--]);
        stack.push(root);
        TreeNode prev = null;
        while(postIndex >= 0) {
            while(!stack.isEmpty() && stack.peek().val == inorder[inIndex]){
                prev = stack.pop();
                inIndex--;
            }
            TreeNode temp = new TreeNode(postorder[postIndex]);
            if(prev == null && !stack.isEmpty()) {
                stack.peek().right = temp;
            } else if(prev != null) {
                prev.left = temp;
            }
            stack.push(temp);
            prev = null;
            postIndex--;
        }
        return root;
    }
}