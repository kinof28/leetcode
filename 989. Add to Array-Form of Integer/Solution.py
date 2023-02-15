from typing import List


class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        extra = 0
        result = []
        for n in reversed(num):
            sum = n+int(k % 10)+extra
            extra = int(sum/10)
            result.append(int(sum % 10))
            k = int(k/10)
        while (extra > 0 or k > 0):
            sum = int(k % 10)+extra
            extra = int(sum/10)
            result.append(int(sum % 10))
            k = int(k/10)
        return result[::-1]
