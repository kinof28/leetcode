# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        def get_list_length(head: Optional[ListNode]) -> int:
            length = 0
            while (head != None):
                length = length+1
                head = head.next
            return length

        def get_middle_node(head: Optional[ListNode], length: int) -> TreeNode:
            if (head == None or length == 0):
                return None
            if (length == 1):
                return TreeNode(head.val, None, None)
            index = 0
            p = head
            pr = None
            while (index < int(length/2) and p.next != None):
                index = index+1
                pr = p
                p = p.next
            if (pr != None):
                pr.next = None
            return TreeNode(p.val, get_middle_node(head, int(length/2)), get_middle_node(p.next, length-index-1))

        return get_middle_node(head, get_list_length(head))


solution = Solution()


def print_tree(head: TreeNode) -> None:
    if (head == None):
        print("Null")

        return
    print(head.val)
    print_tree(head.left)
    print_tree(head.right)


print_tree(solution.sortedListToBST(
    ListNode(-1, ListNode(0, ListNode(1, ListNode(2,  None))))))
