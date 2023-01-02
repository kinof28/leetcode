import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.possibleBipartition(10,
                new int[][] { new int[] { 1, 2 },
                        new int[] { 1, 3 },
                        new int[] { 2, 3 } }));
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] colors;
    Set<Integer> visited = new HashSet<>();

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length < 2)
            return true;
        for (int[] is : dislikes) {
            if (graph.containsKey(is[0])) {
                graph.get(is[0]).add(is[1]);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(is[1]);
                graph.put(is[0], list);
            }
            if (graph.containsKey(is[1])) {
                graph.get(is[1]).add(is[0]);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(is[0]);
                graph.put(is[1], list);
            }
        }
        System.out.println("map keys: " + Arrays.toString(graph.keySet().toArray()));
        colors = new int[dislikes.length];
        return dfs(dislikes[0][0], 1);
    }

    private boolean dfs(int current, int color) {
        System.out.println("current: " + current);
        if (visited.contains(current)) {
            if (colors[current] != color)
                return false;
            else
                return true;
        }
        if (graph.get(current).size() == 0)
            return true;
        if (colors[current] != 0 && colors[current] != color)
            return false;
        if (colors[current] == 0) {
            colors[current] = color;
            visited.add(current);
        }
        int firstChild = graph.get(current).remove(0);
        System.out.println("first child: " + firstChild);
        return dfs(firstChild, color == 1 ? 2 : 1) && dfs(current, color);
    }
}
