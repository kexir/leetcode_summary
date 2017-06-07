/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
    public void copyNext(RandomListNode head) {
        RandomListNode curt = head;
        RandomListNode newNode;
        while( curt != null) {
            newNode = new RandomListNode(curt.label);
            newNode.next = curt.next;
            newNode.random = curt.random;
            curt.next = newNode;
            curt = curt.next.next;
        }
    }
    public void copyRandom(RandomListNode head) {
        RandomListNode curt = head;
        RandomListNode newNode;
        while (curt != null) {
            if (curt.random != null){
                curt.next.random = curt.random.next;
            }
            curt = curt.next.next;
        }
    }
    public RandomListNode split(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head.next;
        while(head != null) {
            RandomListNode temp = head.next;
            head.next = head.next.next;
            head = head.next;
            if ( temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return dummy.next;
    }
}