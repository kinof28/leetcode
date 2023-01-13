# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        def get_length() -> int:
            nonlocal head
            iterator = head
            length = 0
            while (iterator != None):
                length += 1
                iterator = iterator.next
            return length
        size = get_length()
        if ((size-n+1) == 1):
            head = head.next
        else:
            iterator = head
            index = 1
            while (index < size-n):
                iterator = iterator.next
                index += 1
            iterator.next = iterator.next.next
        return head
