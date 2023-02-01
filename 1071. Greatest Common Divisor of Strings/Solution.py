class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if (len(str1) < len(str2)):
            (str1, str2) = (str2, str1)

        def is_divisible_by(str1: str, str2: str) -> bool:
            if (len(str2) == 0):
                return False
            multiply = int(len(str1)/len(str2))
            return str1 == (str2*multiply)
        for i in range(len(str2), 0, -1):
            if (is_divisible_by(str2, str2[-i:]) and is_divisible_by(str1, str2[-i:])):
                return str2[-i:]
        return ""
