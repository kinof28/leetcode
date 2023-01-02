# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        max: int = n
        min: int = 0
        mid = -1
        while (not (min == max and min == mid) and max >= min):
            mid = int((max+min)/2)+(max+min) % 2
            if (isBadVersion(mid)):
                if ((mid-1 == min) or not isBadVersion(mid-1)):
                    return mid
                else:
                    max = mid-1
            else:
                min = mid
        return n
