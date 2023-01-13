# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def get_length() -> int:
            nonlocal head
            iterator = head
            length = 0
            while (iterator != None):
                length += 1
                iterator = iterator.next
            return length

        n = get_length()/2
        iterator = head
        index = 1
        while (index <= n):
            iterator = iterator.next
            index += 1
        return iterator
