# Definition for singly-linked list.
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        def get_len() -> int:
            nonlocal lists
            length = 0
            for l in lists:
                if (l != None):
                    length = length+1
            return length

        def get_min() -> Optional[ListNode]:
            nonlocal lists
            if (get_len() == 0):
                return None
            min_val = 10001
            min_index = 0
            for i, l in enumerate(lists):
                if (l == None):
                    continue
                if (min_val > l.val):
                    min_val = l.val
                    min_index = i
            lists[min_index] = lists[min_index].next
            min_node = ListNode(min_val, get_min())
            return min_node
        return get_min()


solution = Solution()
node = solution.mergeKLists([ListNode(1, ListNode(4, ListNode(5))), ListNode(
    1, ListNode(3, ListNode(4))), ListNode(2, ListNode(6))])


def print_list(node: ListNode):
    while (node != None):
        print(f" -> {node.val}")
        node = node.next


print_list(node)
