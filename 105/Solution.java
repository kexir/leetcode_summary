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
    public TreeNode buildTree(int[] preorder, int[] inorder) {//2ms
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart >= preEnd || inStart >= inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = findLocation(inorder, inStart, inEnd, root.val);
        // number of left children = index - instart
        // start index of right child = preStart + index - instart + 1(root)
        root.left = buildTreeHelper(preorder, preStart+1, preStart-inStart+index+1, inorder, inStart, index);
        root.right = buildTreeHelper(preorder, preStart-inStart+index+1, preEnd, inorder, index+1, inEnd);
        return root;
    }
    public int findLocation(int[] list, int start, int end, int target) {//save time from 37ms(i = start to end) to 2ms
        for(int i = start, j = end-1; i < end && j >= 0; i++, --j) {
            if(list[i] == target) {
                return i;
            }
            if(list[j] == target) {
                return j;
            }
        }
        return -1;
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder) {//5ms
        if(preorder.length == 0 || inorder.length == 0 ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        int preIndex = 1;
        int inIndex = 0;
        while(inIndex < inorder.length) {
            if(!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                prev = stack.pop();
                inIndex++;
            } else {
                TreeNode node = new TreeNode(preorder[preIndex]);
                if(prev == null) {
                    stack.peek().left = node;
                } else {
                    prev.right = node;
                    prev = null;
                }
                stack.push(node);
                preIndex++;
            }
        }
        return root;
    }   
}