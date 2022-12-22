import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.possibleBipartition(10,
                new int[][] { new int[] { 4, 7 },
                        new int[] { 4, 8 },
                        new int[] { 5, 6 },
                        new int[] { 1, 6 },
                        new int[] { 3, 7 },
                        new int[] { 2, 5 },
                        new int[] { 5, 8 },
                        new int[] { 1, 2 },
                        new int[] { 4, 9 },
                        new int[] { 6, 10 },
                        new int[] { 8, 10 },
                        new int[] { 3, 6 },
                        new int[] { 2, 10 },
                        new int[] { 9, 10 },
                        new int[] { 3, 9 },
                        new int[] { 2, 3 },
                        new int[] { 1, 9 },
                        new int[] { 4, 6 },
                        new int[] { 5, 7 },
                        new int[] { 3, 8 },
                        new int[] { 1, 8 },
                        new int[] { 1, 7 },
                        new int[] { 2, 4 } }));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Set<Integer> group1 = new HashSet<>();
        Set<Integer> group2 = new HashSet<>();
        List<int[]> dislikeList = new ArrayList<>(Arrays.asList(dislikes));
        if (dislikeList.size() < 1)
            return true;
        group1.add(dislikeList.get(0)[0]);
        group2.add(dislikeList.get(0)[1]);
        for (int i = 1; i < dislikeList.size(); i++) {
            if (group1.contains(dislikeList.get(i)[0])) {
                if (group1.contains(dislikeList.get(i)[1])) {
                    return false;
                }
                group2.add(dislikeList.get(i)[1]);
            } else if (group2.contains(dislikeList.get(i)[0])) {
                if (group2.contains(dislikeList.get(i)[1])) {
                    return false;
                }
                group1.add(dislikeList.get(i)[1]);
            } else if (group1.contains(dislikeList.get(i)[1])) {
                group2.add(dislikeList.get(i)[0]);
            } else if (group2.contains(dislikeList.get(i)[1])) {
                group1.add(dislikeList.get(i)[0]);
            } else {
                if (canBeAddedRandomly(dislikes, dislikeList.get(i), i)) {
                    group1.add(dislikeList.get(i)[0]);
                    group2.add(dislikeList.get(i)[1]);
                } else {
                    dislikeList.add(dislikeList.get(i));
                }
            }
        }
        return true;
    }

    private boolean canBeAddedRandomly(int[][] dislikes, int[] couple, int coupleIndex) {
        for (int i = coupleIndex + 1; i < dislikes.length; i++) {
            if (couple[0] == dislikes[i][0] || couple[0] == dislikes[i][1] || couple[1] == dislikes[i][0]
                    || couple[1] == dislikes[i][1])
                return false;
        }
        return true;
    }
}