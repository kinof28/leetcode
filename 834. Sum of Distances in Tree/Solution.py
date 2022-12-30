from collections import defaultdict
from typing import List


class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        # result = parent_result - closer_nodes + further_nodes

        graph = defaultdict(list)

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        closer_nodes_count = [0]*n
        result = [0]*n
        visited = set()

        def dfs(current_node):
            nonlocal closer_nodes_count, result
            closer_nodes = 1
            for child in graph[current_node]:
                if (child not in visited):
                    visited.add(child)
                    child_closer_nodes = dfs(child)
                    closer_nodes += child_closer_nodes
                    result[0] += child_closer_nodes

            closer_nodes_count[current_node] = closer_nodes
            return closer_nodes
        visited.add(0)
        dfs(0)

        def dfs2(current_node):
            nonlocal result
            for child in graph[current_node]:
                if (child not in visited):
                    visited.add(child)
                    result[child] = result[current_node] - \
                        closer_nodes_count[child]+(n-closer_nodes_count[child])

                    dfs2(child)

        visited = set()
        visited.add(0)
        dfs2(0)

        return result
