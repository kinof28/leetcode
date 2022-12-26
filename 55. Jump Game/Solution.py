from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        zeros = []
        for i in range(len(nums)-1):
            if (nums[i] == 0):
                zeros.append(i)
        for i in range(len(zeros)):
            for j in range(zeros[i]-1, -1, -1):
                if (nums[j]+j > zeros[i]):
                    zeros[i] = -1
                    break
        for zero in zeros:
            if zero != -1:
                return False
        return True
