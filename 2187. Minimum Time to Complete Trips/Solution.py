from typing import List


class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        if (len(time) == 1):
            return totalTrips*time[0]
        i = 0
        time = sorted(time)
        s = 0
        while (s < totalTrips):
            i = i+1
            s = 0
            for t in time:
                if (t > i):
                    break
                s = s+int(i/t)
        return i


solution = Solution()
print(solution.minimumTime([5, 10, 10], 9))
