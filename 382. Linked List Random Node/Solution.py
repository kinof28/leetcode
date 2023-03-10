# Definition for singly-linked list.
import random
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    def __init__(self, head: Optional[ListNode]):
        self.head = head

    def getRandom(self) -> int:
        if (self.head == None):
            return None
        head = self.head
        res = head.val
        i = 1
        while (head != None):
            if (random.random() < (1/i)):
                res = head.val
            head = head.next
            i = i+1
        return res


# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()
print(random.random)
