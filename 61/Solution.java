/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {//16 ms
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode ans = head;
        for(int i = 0; i < k; i++) {
            if(fast.next == null) {
                k = k%(i+1);
                i = -1;
                fast = head;
                continue;
            }
            fast = fast.next;
        }
        if(fast == slow) {
            return ans;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ans = slow.next;
        fast.next = head;
        slow.next = null;
        return ans;
    }
    public ListNode rotateRight(ListNode head, int k) {//16 ms
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int len = 0;
        while(fast.next != null) {
            len++;
            fast = fast.next;
        }
        for(int i = len - k%len; i > 0; i--) {
            slow = slow.next;
        } 
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}