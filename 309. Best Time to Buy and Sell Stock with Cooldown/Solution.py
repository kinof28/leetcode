from typing import List


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        return self.dfs(prices, 0, True, {})

    def dfs(self, prices: List[int], index: int, buying: bool, profits) -> int:
        if (index >= len(prices)):
            return 0
        if (index, buying) in profits:
            return profits[(index, buying)]
        coolDown = self.dfs(prices, index+1, buying, profits)
        if (buying):
            result = self.dfs(prices, index+1, not buying,
                              profits)-prices[index]
        else:
            result = self.dfs(prices, index+2, not buying,
                              profits)+prices[index]
        profits[(index, buying)] = max(result, coolDown)
        return profits[(index, buying)]
