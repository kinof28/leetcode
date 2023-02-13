class Solution:
    def countOdds(self, low: int, high: int) -> int:
        return int((high/2+high%2)-(low/2)+(low%2 if (high%2 ==0)else 0))

