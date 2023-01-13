from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        def floodFillRec(image: List[List[int]], sr: int, sc: int, color: int, visited) -> List[List[int]]:
            if not (sr >= 0 and sc >= 0 and sr < len(image) and sc < len(image[0])):
                return image
            if (image[sr][sc] != color):
                prev_color = image[sr][sc]
                image[sr][sc] = color
                visited.add((sr, sc))
                if (sr > 0 and image[sr-1][sc] == prev_color and (sr-1, sc)not in visited):
                    floodFillRec(image, sr-1, sc, color, visited)
                if (sr < len(image)-1 and image[sr+1][sc] == prev_color and (sr+1, sc)not in visited):
                    floodFillRec(image, sr+1, sc, color, visited)
                if (sc > 0 and image[sr][sc-1] == prev_color and (sr, sc-1)not in visited):
                    floodFillRec(image, sr, sc-1, color, visited)
                if (sc < len(image[0])-1 and image[sr][sc+1] == prev_color and (sr, sc+1)not in visited):
                    floodFillRec(image, sr, sc+1, color, visited)

            return image
        return floodFillRec(image, sr, sc, color, set())
