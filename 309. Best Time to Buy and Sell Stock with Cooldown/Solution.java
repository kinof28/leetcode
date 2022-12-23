import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> profits = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
    }

    public int dfs(int[] prices, int index, boolean buying) {
        if (index >= prices.length)
            return 0;
        else if (profits.containsKey(index + "" + buying))
            return profits.get(index + "" + buying);
        else {
            int coolDown = dfs(prices, index + 1, buying);
            int val;
            if (buying) {
                val = dfs(prices, index + 1, !buying) - prices[index];
            } else {
                val = dfs(prices, index + 2, !buying) + prices[index];
            }
            profits.put(index + "" + buying, Math.max(val, coolDown));
        }
        return profits.get(index + "" + buying);
    }
}