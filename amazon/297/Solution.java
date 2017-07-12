import java.util.Queue;
import java.util.LinkedList;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class Codec {//37 ms 19%

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode curt = queue.poll();
            if(curt != null) {
                sb.append(String.valueOf(curt.val) + ",");
                queue.offer(curt.left);
                queue.offer(curt.right);
            } else {
                sb.append("#,");
            } 
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(","); 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;       
        while(!queue.isEmpty() && index < nodes.length) {
            TreeNode curt = queue.poll();
            // System.out.println("poll " + curt.val + " " + index);
            if(!nodes[index].equals("#")) {
                curt.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(curt.left);
                // System.out.println("offer " + curt.left.val + " " + index);
            }
            index++;
            if(!nodes[index].equals("#")) {
                curt.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(curt.right);
                // System.out.println("offer " + curt.right.val + " " + index);
            }
            index++;
        }
        return root;
    }
    
public class Solution {//Level Order Traveral
	public static void main(String[] args) {
		Codec codec = new Codec();
        String data = "1,2,-3,#,#,4,5,#,#,#,#,";
		System.out.println(codec.serialize(codec.deserialize(data)));
	}
}

// If given Tree is Binary Search Tree? why?
// If the given Binary Tree is Binary Search Tree, we can store it by either storing preorder or postorder traversal. In case of Binary Search Trees, only preorder or postorder traversal is sufficient to store structure information.

// If given Binary Tree is Complete Tree?
// A Binary Tree is complete if all levels are completely filled except possibly the last level and all nodes of last level are as left as possible (Binary Heaps are complete Binary Tree). For a complete Binary Tree, level order traversal is sufficient to store the tree. We know that the first node is root, next two nodes are nodes of next level, next four nodes are nodes of 2nd level and so on.

// If given Binary Tree is Full Tree?
// A full Binary is a Binary Tree where every node has either 0 or 2 children. It is easy to serialize such trees as every internal node has 2 children. We can simply store preorder traversal and store a bit with every node to indicate whether the node is an internal node or a leaf node
