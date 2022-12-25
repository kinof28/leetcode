from typing import List


class Solution:
    def numTilings(self, n: int) -> int:
        return self.numTilingsRecursively(n, [0]*(n+1))

    def numTilingsRecursively(self, n: int, dp: List[int]) -> int:
        if (n < 0):
            return 0
        if (n == 0):
            return 1
        if (n < 3):
            return n
        if (n == 3):
            return 5
        if (not dp[n] == 0):
            return int(dp[n] % (1e9 + 7))
        else:
            result = 2 * \
                self.numTilingsRecursively(
                    n-1, dp)+self.numTilingsRecursively(n-3, dp)
            dp[n] = result
            return int(result % (1e9 + 7))
