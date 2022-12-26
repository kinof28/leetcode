import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean canJump(int[] nums) {
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0)
                zeros.add(i);
        }
        for (int i = 0; i < zeros.size(); i++) {
            for (int j = zeros.get(i) - 1; j >= 0; j--) {
                if (j + nums[j] > zeros.get(i)) {
                    zeros.remove(i);
                    i--;
                    break;
                }
            }
            if (zeros.isEmpty())
                break;
        }
        return zeros.isEmpty();
    }
}