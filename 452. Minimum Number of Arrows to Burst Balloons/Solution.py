from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        sum: int = 0
        while (len(points) > 0):
            current: List[int] = points.pop(0)
            interval = current
            sum += 1
            while (len(points) > 0):
                point = points[0]
                if ((interval[0] >= point[0] and interval[0] <= point[1]) or
                    (interval[1] >= point[0] and interval[1] <= point[1]) or
                    (point[0] >= interval[0] and point[0] <= interval[1]) or
                        (point[1] >= interval[0] and point[1] <= interval[1])):
                    popped = points.pop(0)
                    interval[0] = max(interval[0], popped[0])
                    interval[1] = min(interval[1], popped[1])
                else:
                    break
        return sum
