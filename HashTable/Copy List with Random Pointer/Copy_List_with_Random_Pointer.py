# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head == None:
        	return
        hash_map = {}
        newHead = RandomListNode(head.label)
        hash_map[head] = newHead
        p = head
        q = newHead
        while p != None:
        	q.random = p.random
        	if p.next != None:
        		q.next = RandomListNode(p.next.label)
        		hash_map[p.next] = q.next
        	else:
        		q.next = None
        	p = p.next
        	q = q.next

        p = newHead
        while p != None:
        	if p.random != None:
        		p.random = hash_map[p.random]
        	p = p.next

        return newHead
        	
