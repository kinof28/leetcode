class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        leading_index = 0
        ending_index = len(s)
        for c in s:
            if (c == '1'):
                break
            else:
                leading_index += 1
        for c in reversed(s):
            if (c == '0'):
                break
            else:
                ending_index -= 1
        zeros = 0
        ones = 0
        for c in s[leading_index:ending_index]:
            if (c == '0'):
                zeros += 1
            else:
                ones += 1
        if (leading_index == 0):
            return min(min(zeros, ones), 1+self.minFlipsMonoIncr(s[1:]))
        return min(zeros, ones)


solution = Solution()
print(solution.minFlipsMonoIncr("10011111110010111011"))
