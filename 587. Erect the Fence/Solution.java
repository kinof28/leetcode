import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length < 4)
            return trees;
        int mostLeftTreeIndex = 0;
        for (int i = 1; i < trees.length; i++) {
            if (trees[mostLeftTreeIndex][0] < trees[i][0])
                mostLeftTreeIndex = i;
        }
        Set<int[]> resultSet = new HashSet<>();
        resultSet.add(trees[mostLeftTreeIndex]);
        int current, candidate;
        current = mostLeftTreeIndex;
        while (true) {
            candidate = (current + 1) % trees.length;
            for (int i = 0; i < trees.length; i++) {
                if (isMoreClockWise(trees[current], trees[candidate], trees[i]) > 0) {
                    candidate = i;
                }
            }
            for (int[] is : trees) {
                if (isMoreClockWise(trees[current], trees[candidate], is) == 0)
                    resultSet.add(is);
            }
            current = candidate;
            if (current == mostLeftTreeIndex)
                break;
        }
        return resultSet.toArray(new int[][] {});
    }

    private int isMoreClockWise(int[] firstPoint, int[] secondPoint, int[] thirdPoint) {

        return ((thirdPoint[0] - firstPoint[0]) * (secondPoint[1] - firstPoint[1]))
                - ((secondPoint[0] - firstPoint[0]) * (thirdPoint[1] - firstPoint[1]));
    }
}