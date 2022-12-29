from queue import PriorityQueue
from typing import List


class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        order = []
        firstPriorityQueue = PriorityQueue()
        secondPriorityQueue = PriorityQueue()
        for i in range(len(tasks)):
            firstPriorityQueue.put(Process(i, tasks[i][0]))

        current = firstPriorityQueue.get()
        secondPriorityQueue.put(
            Process(current.index, tasks[current.index][1]))
        currentTime = current.time

        while (len(order) < len(tasks)):
            while (not firstPriorityQueue.empty()):
                next = firstPriorityQueue.get()
                if (next.time > currentTime):
                    firstPriorityQueue.put(next)
                    break
                else:
                    secondPriorityQueue.put(
                        Process(next.index, tasks[next.index][1]))
                    current = next

            if (not secondPriorityQueue.empty()):
                temp = secondPriorityQueue.get()
                order.append(temp.index)
                currentTime = currentTime + temp.time
            else:
                temp = firstPriorityQueue.get()
                currentTime = temp.time
                firstPriorityQueue.put(temp)

        return order


class Process:
    def __init__(self, index, time) -> None:
        self.index = index
        self.time = time

    def __eq__(self, __o: object) -> bool:
        return self.time == __o.time and self.index == __o.index

    def __lt__(self, __o: object) -> bool:
        if (self.time == __o.time):
            return self.index < __o.index
        else:
            return self.time < __o.time
