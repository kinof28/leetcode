import java.util.Arrays;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int diff[] = new int[capacity.length];
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < diff.length; i++) {
            additionalRocks -= diff[i];
            if (additionalRocks >= 0) {
                sum++;
            } else
                break;
        }
        return sum;
    }
}