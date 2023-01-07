from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # starting = 0
        for i in range(len(gas)):
            if (gas[i] >= cost[i]):
                possible = True
                available_gas = 0
                starting = i
                available_gas = gas[i]-cost[i]
                j = (i+1) % len(gas)
                while (possible):
                    if (j == starting):
                        return starting
                    if ((gas[j]+available_gas) >= cost[j]):
                        available_gas = (gas[j]+available_gas)-cost[j]
                        j = (j+1) % len(gas)
                    else:
                        possible = False
        return -1


solution = Solution()
print(solution.canCompleteCircuit([2, 3, 4], [3, 4, 3]))
