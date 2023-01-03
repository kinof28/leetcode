from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        tempArray1 = nums[:n-k]
        tempArray2 = nums[n-k:]
        for i in range(len(tempArray2)):
            nums[i] = tempArray2[i]
        for i in range(len(tempArray2), n):
            nums[i] = tempArray1[i-len(tempArray2)]
