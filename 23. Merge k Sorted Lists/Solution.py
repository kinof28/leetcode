# Definition for singly-linked list.
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_val = 10001
        min_index = -1
        for i, l in enumerate(lists):
            if (l == None):
                continue
            if (min_val > l.val):
                min_val = l.val
                min_index = i
        if (min_index == -1):
            return None
        lists[min_index] = lists[min_index].next
        if (lists[min_index] == None):
            lists.remove(None)
        min_node = ListNode(min_val, self.mergeKLists(lists))
        return min_node


solution = Solution()
node = solution.mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(
    1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))])


def print_list(node: ListNode):
    while (node != None):
        print(f" -> {node.val}")
        node = node.next


print_list(node)
