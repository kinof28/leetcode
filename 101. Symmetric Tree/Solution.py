# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def is_array_symmetric(array) -> bool:
            n = len(array)
            for i in range(int(n/2)):
                if (array[i] == None and array[n-1-i] == None):
                    continue
                if (array[i] == None or array[n-1-i] == None):
                    return False
                if (array[i].val != array[n-1-i].val):
                    return False
            return True

        def bfs(nodes: List[TreeNode]) -> bool:
            if (len(nodes) == 0):
                return True
            nodes_to_visit = []
            for node in nodes:
                if (node == None):
                    continue
                nodes_to_visit.append(node.left)
                nodes_to_visit.append(node.right)
            return is_array_symmetric(nodes) and bfs(nodes_to_visit)
        return bfs([root])
