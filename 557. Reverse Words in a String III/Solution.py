class Solution:
    def reverseWords(self, s: str) -> str:
        words_array = s.split(" ")
        result: str = ""
        for word in words_array:
            word = word[::-1]
            result = result+word+" "
        result = result[:-1]
        return result
