import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Boolean> validPathMap = new HashMap<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        if (edges.length == 0)
            return false;
        if (validPathMap.containsKey(source))
            return validPathMap.get(source);
        int newSource;
        boolean result;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == source || edges[i][1] == source) {
                newSource = edges[i][0] == source ? edges[i][1] : edges[i][0];
                edges[i][0] = -1;
                edges[i][1] = -1;
                result = (validPath(n, edges, newSource, destination) || validPath(n, edges, source, destination));
                validPathMap.put(source, result);
                return result;
            }
        }
        return false;
    }
}