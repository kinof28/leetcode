from typing import List


class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        if (len(time) == 1):
            return totalTrips*time[0]
        i = 0
        time = sorted(time)
        s = 0
        l = time[0]
        h = time[len(time)-1]*totalTrips
        while (l <= h):
            i = l+int((h-l)/2)
            s = 0
            for t in time:
                if (t > i):
                    break
                s = s+int(i/t)
            if (s >= totalTrips):
                ans = i
                h = i-1
            else:
                l = i+1
        return ans
