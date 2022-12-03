import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                map.replace(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        Object[] values = map.values().toArray();
        Arrays.sort(values);
        String result = "";
        char ch = '.';
        for (int i = 0; i < values.length; i++) {
            for (char c : map.keySet()) {
                if (map.get(c) == values[i]) {
                    ch = c;
                    break;
                }
            }
            map.remove(ch);
            for (int j = 0; j < (int) values[i]; j++) {
                result = ch + result;
            }
        }
        return result;
    }
}