from typing import List


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        sum: int = 0
        for i in range(len(strs[0])):
            previous_str: str = strs[0]
            for string in strs[1:]:
                if (previous_str[i] > string[i]):
                    sum += 1
                    break
                previous_str = string
        return sum
