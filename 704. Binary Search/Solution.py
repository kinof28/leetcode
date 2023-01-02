from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        min = 0
        max = len(nums)-1
        mid = -1
        while (not (min == max and min == mid) and max >= min):
            mid = int((max+min)/2)
            if (nums[mid] == target):
                return mid
            elif (target > nums[mid]):
                min = mid+1
            elif (target < nums[mid]):
                max = mid-1
        return -1
