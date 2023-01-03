from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        min: int = 0
        max: int = len(nums)-1
        while (min <= max):
            mid: int = int((max+min)/2)+(max+min) % 2
            if (nums[max] < target):
                return max+1
            if (nums[min] >= target):
                return min
            if (nums[mid] == target):
                return mid
            elif (nums[mid] > target):
                max = mid-1
            elif (nums[mid] < target):
                min = mid+1
        return mid
