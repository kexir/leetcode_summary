import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        findFrequentTreeSum(root);
    }
    public static int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findFrequentTreeSumHelper(root, map, temp, max);
        System.out.println(temp);
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
    public static int findFrequentTreeSumHelper(TreeNode root, HashMap<Integer, Integer> map, ArrayList<Integer> temp, int[] max) {
        if(root == null) {
            return 0;
        }
        int left = findFrequentTreeSumHelper(root.left, map, temp, max);
        int right = findFrequentTreeSumHelper(root.right, map, temp, max);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        if(map.get(sum) > max[0]) {
            max[0] = sum;
            temp.clear();
            temp.add(sum);
            System.out.println(max[0] + " " + sum);
        } else if(map.get(sum) == max[0]) {
            temp.add(sum);
            System.out.println(sum);
        }
        return sum;
    }
}