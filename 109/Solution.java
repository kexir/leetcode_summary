/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTHelper(head, null);
    }
    public TreeNode sortedListToBSTHelper(ListNode head, ListNode tail) {
        if(head == null || head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail) {
            fast = fast.next;
            if(fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBSTHelper(head, slow);
        root.right = sortedListToBSTHelper(slow.next, tail);
        return root;
    }
}