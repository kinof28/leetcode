from typing import List


class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        if (len(nums) < 2):
            return nums[0]
        max_sum = nums[0]
        min_sum = nums[0]
        cur_min = 0
        cur_max = 0
        total_sum = 0
        for num in nums:
            cur_max = max(cur_max + num, num)
            max_sum = max(max_sum, cur_max)
            cur_min = min(cur_min + num, num)
            min_sum = min(min_sum, cur_min)
            total_sum += num
        return max(max_sum, total_sum-min_sum)if max_sum > 0 else max_sum
