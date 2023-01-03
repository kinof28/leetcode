from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        def searchInsert(nums: List[int], target: int) -> int:
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
        starting_index = searchInsert(nums, 0)
        new_nums = []
        for num in nums[starting_index:]:
            new_nums.append(num*num)

        for num in nums[:starting_index]:
            pos = searchInsert(new_nums, (num*num))
            new_nums = new_nums[:pos]+[(num*num)]+new_nums[pos:]
        return new_nums
