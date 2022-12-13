class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                else if (j == matrix.length - 1)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                else
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1][i] < min)
                min = matrix[matrix.length - 1][i];
        }
        return min;
    }

}