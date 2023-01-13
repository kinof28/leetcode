from typing import List


class Node:
    def __init__(self, val: int) -> None:
        self.val = val
        self.children: List[Node] = []

    def add_child(self, child) -> None:
        self.children.append(child)


class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:

        tree = dict()

        def build_tree() -> None:
            nonlocal tree
            for i, p in enumerate(parent):
                tree[i] = []

                pass

        def dfs() -> int:
            return 0

        return dfs()
