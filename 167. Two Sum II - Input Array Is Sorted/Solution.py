from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        for i in range(len(numbers)):
            if (i != 0 and numbers[i] == numbers[i-1] and (numbers[i] + numbers[i-1]) != target):
                continue
            for j in range(i+1, len(numbers)):
                if ((numbers[i]+numbers[j]) > target):
                    break
                if ((numbers[i]+numbers[j]) == target):
                    return [i+1, j+1]
        return None
