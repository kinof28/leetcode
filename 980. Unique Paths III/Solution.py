from typing import List


class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        empty_squares: int = 0
        x_start: int = 0
        y_start: int = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (grid[i][j] == 1):
                    x_start = i
                    y_start = j
                elif (grid[i][j] == 0):
                    empty_squares += 1

        def dfs(grid: List[List[int]], x: int, y: int, empty_squares: int) -> int:
            if (x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or grid[x][y] == -1):
                return 0
            if (grid[x][y] == 2):
                return 1 if empty_squares == -1 else 0

            empty_squares = empty_squares-1
            grid[x][y] = -1
            total_paths: int = dfs(grid, (x+1), y, empty_squares) +\
                dfs(grid, x-1, y, empty_squares) +\
                dfs(grid, x, y+1, empty_squares) +\
                dfs(grid, x, y-1, empty_squares)

            empty_squares = empty_squares+1
            grid[x][y] = 0

            return total_paths

        return dfs(grid, x_start, y_start, empty_squares)
