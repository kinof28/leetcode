import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, int[]> graphMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            graphMap.put(i, graph[i]);
        }
        testRoad(0, graph.length - 1, new LinkedList<>(), graphMap);
        return result;
    }

    public void testRoad(int root, int end, List<Integer> road, Map<Integer, int[]> graphMap) {
        road.add(root);
        if (root == end) {
            result.add(road);
            return;
        } else if (graphMap.get(root).length == 0)
            return;
        else {
            for (int integer : graphMap.get(root)) {
                testRoad(integer, end, new LinkedList<>(road), graphMap);
            }
        }
    }
}