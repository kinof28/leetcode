class Solution {
    public int uniquePathsIII(int[][] grid) {
        int emptySquares = 0;
        int[] startingIndex = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    emptySquares++;
                if (grid[i][j] == 1) {
                    startingIndex[0] = i;
                    startingIndex[1] = j;
                }

            }
        }
        return dfs(grid, startingIndex, emptySquares);
    }

    private int dfs(int[][] grid, int[] startingIndex, int emptySquares) {
        if (startingIndex[0] < 0 || startingIndex[0] >= grid.length || startingIndex[1] < 0
                || startingIndex[1] >= grid[0].length || grid[startingIndex[0]][startingIndex[1]] == -1) {
            return 0;
        }
        if (grid[startingIndex[0]][startingIndex[1]] == 2) {
            return emptySquares == -1 ? 1 : 0;
        }
        grid[startingIndex[0]][startingIndex[1]] = -1;
        emptySquares--;
        int totalPaths = dfs(grid, new int[] { startingIndex[0] + 1, startingIndex[1] }, emptySquares) +
                dfs(grid, new int[] { startingIndex[0] - 1, startingIndex[1] }, emptySquares) +
                dfs(grid, new int[] { startingIndex[0], startingIndex[1] + 1 }, emptySquares) +
                dfs(grid, new int[] { startingIndex[0], startingIndex[1] - 1 }, emptySquares);

        grid[startingIndex[0]][startingIndex[1]] = 0;
        emptySquares++;

        return totalPaths;
    }
}