from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums_copy = nums.copy()
        i = 0
        for num in nums_copy:
            if (num != 0):
                nums[i] = num
                i += 1
        for j in range(i, len(nums_copy)):
            nums[j] = 0
