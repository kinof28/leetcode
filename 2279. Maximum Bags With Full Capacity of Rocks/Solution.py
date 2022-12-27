from typing import List


class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        differences = []
        for i in range(len(capacity)):
            differences.append(capacity[i]-rocks[i])
        differences.sort()
        sum = 0
        for difference in differences:
            additionalRocks = additionalRocks-difference
            if (additionalRocks >= 0):
                sum = sum+1
            else:
                break
        return sum
