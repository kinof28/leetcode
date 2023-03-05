from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        def count_recursive(nums: List[int],  current_min: int, current_max: int) -> int:
            nonlocal minK, maxK
            # print("current_min = ", current_min)
            # print("current_max = ", current_max)
            # print("current nums = ", nums)
            if (len(nums) == 1 and ((nums[0] == minK == maxK) or (current_min == minK and current_max == maxK and nums[0] >= minK and nums[0] <= maxK))):
                return 1
            elif (len(nums) == 1):
                return 0
            if (nums[0] < minK or nums[0] > maxK):
                return count_recursive(nums[1:], nums[1], nums[1])
            if (nums[0] < current_min):
                current_min = nums[0]
            if (nums[0] > current_max):
                current_max = nums[0]
            if (current_min == minK and current_max == maxK and nums[0] >= minK and nums[0] <= maxK):
                return 1+count_recursive(nums[1:], current_min, current_max)
            else:
                return count_recursive(nums[1:], current_min, current_max)
        return count_recursive(nums, nums[0], nums[0])


solution = Solution()
print(solution.countSubarrays([1, 1, 1, 1], 1, 1))
