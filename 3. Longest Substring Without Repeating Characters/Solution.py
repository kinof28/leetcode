class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_length = 0
        for i in range(len(s)):
            subString = set()
            subString.add(s[i])
            length = 1
            for j in range(i+1, len(s)):
                if (s[j] not in subString):
                    subString.add(s[j])
                    length += 1
                else:
                    break
            if (length > max_length):
                max_length = length
        return max_length
