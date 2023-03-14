# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(root: TreeNode, prev: str) -> int:
            result = 0
            if (root == None):
                return result
            if (root.left == None and root.right == None):
                return int(prev+str(root.val))
            if (root.left != None):
                result = result+dfs(root.left, prev+str(root.val))
            if (root.right != None):
                result = result+dfs(root.right, prev+str(root.val))
            return result
        return dfs(root, "")
