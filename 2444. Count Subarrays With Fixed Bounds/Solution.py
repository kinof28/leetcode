from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        sum = 0
        for i in range(len(nums)):
            min = nums[i]
            max = nums[i]
            if (min < minK or max > maxK):
                continue
            for n in nums[i:]:
                if (n <= min):
                    min = n
                if (n >= max):
                    max = n
                if (min == minK and max == maxK):
                    sum = sum+1
        return sum


solution = Solution()
print(solution.countSubarrays([35054, 398719, 945315, 945315, 820417, 945315,
      35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913], 35054, 945315))
