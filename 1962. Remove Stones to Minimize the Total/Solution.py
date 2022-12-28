import math
from queue import PriorityQueue
from typing import List


class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        pq = PriorityQueue()
        for pile in piles:
            pq.put(-pile)
        for i in range(k):
            val = pq.get()
            val = val+math.floor(-val/2)
            pq.put(val)
        sum = 0
        while not pq.empty():
            val = pq.get()
            print(val)
            sum = sum-val
        return sum
