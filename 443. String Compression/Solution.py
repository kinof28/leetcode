from typing import List


class Solution:
    def compress(self, chars: List[str]) -> int:
        result = ""
        i = 0
        n = len(chars)
        while i < n:
            index = i+1
            count = 1
            while (index < n and chars[index] == chars[i]):
                count = count+1
                index = index+1
            result = result+chars[i]
            if (count > 1):
                dist = str(count)
                for c in dist:
                    result = result+c
            i = index
        for i, c in enumerate(result):
            chars[i] = c
        return len(result)
