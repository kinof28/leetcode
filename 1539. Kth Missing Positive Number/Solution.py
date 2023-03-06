from typing import List


class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        missing = []
        max_val = max(arr)
        for i in range(1, max_val):
            if (i not in arr):
                missing.append(i)
        while (len(missing) < k):
            max_val = max_val+1
            missing.append(max_val)

        return missing[k-1]
