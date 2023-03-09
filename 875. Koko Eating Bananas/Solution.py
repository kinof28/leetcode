from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        k = 0
        s = 0
        total_bananas = sum(piles)
        l = 1
        h = max(piles)
        n = len(piles)
        print(f"total bananas: {total_bananas}")
        while (l <= h):
            k = l+int((h-l)/2)
            s = 0
            index = 0
            piles_copy = piles.copy()
            for i in range(h):
                s = s+min(piles_copy[index], k)
                piles_copy[index] = piles_copy[index]-k
                if (piles_copy[index] <= 0):
                    index = index+1
                if (index >= n):
                    break
            if (s >= total_bananas):
                ans = k
                h = k-1
            else:
                l = k+1
                print(f"test for k = {k} ,with s ={s}, then low becomes: {l}")
        print(f"height: {h} ,low: {l}")
        return ans


solution = Solution()
print(solution.minEatingSpeed([3, 6, 7, 11], 8))
