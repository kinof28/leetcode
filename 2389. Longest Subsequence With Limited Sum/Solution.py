from typing import List


class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        result = []
        nums.sort()
        for query in queries:
            result.append(self.answerQuery(nums, query))

        return result

    def answerQuery(self, nums: List[int], query: int) -> int:
        sum = 0
        result = 0
        for num in nums:
            sum += num
            if (sum > query):
                break
            else:
                result = result+1
        return result
