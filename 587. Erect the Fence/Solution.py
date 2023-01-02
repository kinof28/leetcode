from typing import List


class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        if (len(trees) < 4):
            return trees
        mostLeftTreeIndex: int = 0
        for i in range(len(trees)):
            if trees[i][0] < trees[mostLeftTreeIndex][0]:
                mostLeftTreeIndex = i
        currentTree = mostLeftTreeIndex
        result = set()
        while True:
            candidate = (currentTree+1) % len(trees)

        return result
