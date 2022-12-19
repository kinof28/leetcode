import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.get(x).add(y);
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(y).add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> seen = new HashSet<>();
        seen.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                return true;
            }
            if (graph.containsKey(cur)) {
                for (int nei : graph.get(cur)) {
                    if (!seen.contains(nei)) {
                        queue.offer(nei);
                        seen.add(nei);
                    }
                }
            }
        }
        return false;
    }
}