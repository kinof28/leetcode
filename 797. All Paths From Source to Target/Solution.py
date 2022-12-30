from collections import defaultdict
from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        result = []
        graphMap = defaultdict(list)
        for i in range(len(graph)):
            graphMap[i] = graph[i]

        def test_road(root: int, end: int, road: List[int]):
            nonlocal graphMap, result
            road.append(root)
            if (root == end):
                result.append(road)
                return
            elif (len(graphMap[root]) == 0):
                return
            else:
                for child in graphMap[root]:
                    test_road(child, end, road.copy())

        test_road(0, len(graph)-1, [])
        return result
