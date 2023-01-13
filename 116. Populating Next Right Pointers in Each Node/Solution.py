from typing import Optional


# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: Optional[Node]) -> Optional[Node]:
        queue = []
        queue.append(root)

        def connectReq(queue) -> None:
            if (len(queue) < 1):
                return
            else:
                new_queue = []
                element = queue.pop(0)
                if (element == None):
                    return
                while (len(queue) > 0):
                    if (element.left != None):
                        new_queue.append(element.left)
                    if (element.right != None):
                        new_queue.append(element.right)
                    element.next = queue[0]
                    element = queue.pop(0)
                if (element.left != None):
                    new_queue.append(element.left)
                if (element.right != None):
                    new_queue.append(element.right)
                element.next = None
            connectReq(new_queue)
        connectReq(queue)
        return root
