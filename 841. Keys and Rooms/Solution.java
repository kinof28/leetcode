import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add((new LinkedList<>()));
        rooms.add((new LinkedList<>()));
        rooms.add((new LinkedList<>()));
        rooms.add((new LinkedList<>()));
        rooms.get(0).add(1);
        rooms.get(1).add(2);
        rooms.get(2).add(3);
        System.out.println(solution.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        keys.add(0);
        boolean modified = true;
        Object[] currentKeys;
        while (modified) {
            currentKeys = keys.toArray();
            for (Object integer : currentKeys) {
                keys.addAll(rooms.get((int) integer));
            }
            if (currentKeys.length == keys.size()) {
                modified = false;
            }
        }
        return keys.size() == rooms.size();
    }
}