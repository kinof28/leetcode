from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        available_gas = 0
        starting_index = 0
        for i in range(n*2):
            available_gas += gas[i % n]-cost[i % n]
            if (available_gas < 0):
                available_gas = 0
                starting_index = i+1
            elif (i-starting_index+1 == n):
                return starting_index
        return -1
