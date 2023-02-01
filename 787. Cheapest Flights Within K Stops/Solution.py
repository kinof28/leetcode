from typing import List


class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        if (k == 0):
            for flight in flights:
                if (flight[0] == src):
                    if (flight[1] == dst):
                        return flight[2]
            return -1
        return 0
