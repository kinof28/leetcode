from typing import List


class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()
        sum = 0
        for cost in costs:
            if (cost > coins):
                break
            else:
                coins -= cost
                sum += 1
        return sum
