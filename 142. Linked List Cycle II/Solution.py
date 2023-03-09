
from typing import Optional

# Definition for singly-linked list.


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        nodes = []
        p = head
        while (p != None and p not in nodes and p.next != None):
            nodes.append(p)
            p = p.next
        if (p in nodes):
            return p
        return None
