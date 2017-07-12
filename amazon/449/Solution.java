/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {//preoder with no null element 25 ms
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curt = stack.pop();
            sb.append(String.valueOf(curt.val)+",");
            if(curt.right != null) {
                stack.push(curt.right);
            }
            if(curt.left != null) {
                stack.push(curt.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] nodes = data.split(",");
        return helper(nodes, 0, nodes.length);
    }
    public TreeNode helper(String[] nodes, int start, int end) {
        if(start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[start]));
        int i;
        for(i = start+1; i < end; i++) {
            if(Integer.parseInt(nodes[i]) > Integer.parseInt(nodes[start])) {
                break;
            }
        }
        root.left = helper(nodes, start+1, i);
        root.right = helper(nodes, i, end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));