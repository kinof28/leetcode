from typing import List


class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        if (len(trees) < 4):
            return trees
        mostLeftTreeIndex: int = 0
        for i in range(len(trees)):
            if trees[i][0] > trees[mostLeftTreeIndex][0]:
                mostLeftTreeIndex = i
        currentTreeIndex = mostLeftTreeIndex
        result = set()
        result.add(tuple(trees[mostLeftTreeIndex]))

        def isMoreClockWise(first_tree: List[int], second_tree: List[int], third_tree: List[int],) -> int:
            return ((third_tree[0]-first_tree[0])*(second_tree[1]-(first_tree[1])))-((second_tree[0]-first_tree[0])*(third_tree[1]-first_tree[1]))

        while True:
            candidateIndex = (currentTreeIndex+1) % len(trees)
            for i, tree in enumerate(trees):
                if (isMoreClockWise(trees[currentTreeIndex], trees[candidateIndex], tree) > 0):
                    candidateIndex = i
            for tree in trees:
                if (isMoreClockWise(trees[currentTreeIndex], trees[candidateIndex], tree) == 0):
                    result.add(tuple(tree))

            currentTreeIndex = candidateIndex
            if (currentTreeIndex == mostLeftTreeIndex):
                return result
