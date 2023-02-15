from typing import List


class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        extra = 0
        print(num)
        num = num[::-1]
        result = []
        for n in reversed(num[:-1]):
            sum = n+int(k % 10)+extra
            extra = int(sum/10)
            result.append(int(sum % 10))
            k = int(k/10)
        sum = num[-1]+k+extra
        # result = result[::-1]
        while (sum > 0):
            result.append(int(sum % 10))
            sum = int(sum/10)
        return result


solution = Solution()
print(solution.addToArrayForm(
    [1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3], 516))
