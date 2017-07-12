import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class Codec {//preoder backtracking 18 ms 92.87%

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }
    public static void build(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return ;
        }
        sb.append(String.valueOf(root.val) + ",");
        build(root.left, sb);
        build(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = new int[]{0};
        return helper(nodes, index);
        
    }
    public static TreeNode helper(String[] nodes, int[] index) {
        if(index[0] >= nodes.length || nodes[index[0]].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0] += 1;
        root.left = helper(nodes, index);
        index[0] += 1;
        root.right = helper(nodes, index);
        return root;
    }
}

public class Solution1 {
	public static void main(String[] args) {
		Codec codec = new Codec();
        String data = "5,3,2,#,#,-4,#,#,8,-6,#,7,10,9,#,#,#";
        System.out.println(codec.serialize(codec.deserialize(data)));
	}

}
