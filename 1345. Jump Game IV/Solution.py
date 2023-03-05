from typing import List


class Node:
    val: int
    left: int
    right: int
    same: List[int]
    distance: int


class Solution:
    def minJumps(self, arr: List[int]) -> int:
        visited = []
        next = []
        non_checked = [i for i in range(len(arr))]

        def getNode(index: int, distance: int) -> Node:
            nonlocal arr, non_checked
            node = Node()
            node.val = index
            node.distance = distance
            node.left = -1 if (index == 0) else index-1
            node.right = index+1 if (len(arr) > index+1) else -1
            node.same = []
            for i in non_checked:
                if arr[i] == arr[index] and i != index:
                    node.same.append(i)
            for s in node.same:
                non_checked.remove(s)
            return node

        def bfs(root: Node, target: int) -> int:
            nonlocal arr, visited, next
            if (root.val == target):
                return root.distance
            visited.append(root.val)
            if (root.left != -1 and root.left not in visited):
                next.append(getNode(root.left, root.distance+1))
            if (root.right < len(arr) and root.right not in visited):
                next.append(getNode(root.right, root.distance+1))
            for s in root.same:
                if (s not in visited):
                    next.append(getNode(s, root.distance+1))
            result = []
            while (len(next) > 0):
                result.append(bfs(next.pop(0), target))
            return min(result) if len(result) > 0 else 999999
        first_Node = getNode(0, 0)

        return bfs(first_Node, len(arr)-1)


solution = Solution()
print(solution.minJumps([100, -23, -23, 404, 100, 23, 23, 23, 3, 404]))
# print(min([]))
